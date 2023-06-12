//package boj.p16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * boj 16234 인구 이동
 * */
public class Main{

	static int N, L, R;
	static int result;
	static int[][] maps;

	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		maps = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();

		System.out.println(result);
	}

	static void solve() {

		while (true) {
			boolean[][] visited = new boolean[N][N];
			boolean checkMoving = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && bfs(i, j, visited)) {
						checkMoving = true;
					}
				}
			}
			if (!checkMoving)
				break;

			result++;
		}

	}

	static boolean bfs(int row, int col, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		LinkedList<int[]> lists = new LinkedList<>();

		queue.add(new int[] {row, col});
		visited[row][col] = true;
		lists.add(new int[] {row, col});

		int sum = maps[row][col];

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];

			for (int d = 0; d < dir.length; d++) {
				int nextX = nowX + dir[d][0];
				int nextY = nowY + dir[d][1];

				if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= N || visited[nextX][nextY])
					continue;

				int diff = Math.abs(maps[nowX][nowY] - maps[nextX][nextY]);
				if (diff >= L && diff <= R) {
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY});
					lists.add(new int[] {nextX, nextY});
					sum += maps[nextX][nextY];
				}
			}
		}

		if (lists.size() == 1)
			return false;

		//연합 인구 수 평균으로 변경
		int avg = sum / lists.size();
		changeMapsByAvg(avg, lists);

		return true;
	}

	static void changeMapsByAvg(int avg, LinkedList<int[]> lists) {
		for (int[] tmp : lists) {
			int x = tmp[0];
			int y = tmp[1];
			maps[x][y] = avg;
		}
	}

}
