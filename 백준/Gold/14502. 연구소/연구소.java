//package boj.p14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static Queue<int[]> queue;
	private static int[][] maps;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		queue = new LinkedList<>();
		result = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		choiceLocation(new int[3][], 0,new boolean[N][M]);

		System.out.println(result);
	}


	static void getVirus(int[][] input) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(input[i][j] == 2) {
					queue.add(new int[] {i, j});
				}
			}
		}
	}
	
	//세울 수 있는 벽의 위치를 전부 구함
	static void choiceLocation(int[][] output, int cnt, boolean[][] checked) {
		if(cnt == 3) {
			int[][] copyMaps = new int[N][M];
			copyArray(maps, copyMaps);
			for (int i = 0; i < output.length; i++) {
				copyMaps[output[i][0]][output[i][1]] = 1;
			}
			getVirus(copyMaps);
			solve(copyMaps);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(maps[i][j] == 0 && !checked[i][j]) {
					checked[i][j] = true;
					output[cnt] = new int[] {i, j};
					choiceLocation(output, cnt+1,checked);
					checked[i][j] = false;					
				}
			}
		}
	}
	
    //배열 복사
	static void copyArray(int[][] original, int[][] copy) {
		for (int i = 0; i < N; i++) {
			System.arraycopy(original[i], 0, copy[i], 0, copy[i].length);	
		}
	}
	
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우

	static void solve(int[][] input) {
		boolean[][] visited = new boolean[N][M];

		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nowX = temp[0];
			int nowY = temp[1];
			
			visited[nowX][nowY] = true;
			
			for (int i = 0; i < dir.length; i++) {
				int nextX = nowX + dir[i][0];
				int nextY = nowY + dir[i][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
				if(visited[nextX][nextY]) continue;
				
				if(input[nextX][nextY] == 0) {
					input[nextX][nextY] = 2;
					queue.add(new int[] {nextX, nextY});
				}	
			}
		}
		result = Math.max(getCount(input), result);

	}
	
	
	static int getCount(int[][] input) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(input[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}

