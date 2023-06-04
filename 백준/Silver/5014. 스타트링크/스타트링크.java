//package boj.p5014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * boj 5014 스타트링크
 * */
public class Main {
	static int F, G, U, D;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		result = Integer.MAX_VALUE;

		solve(S);

		System.out.println(result == Integer.MAX_VALUE ? "use the stairs" : result);

	}

	static void solve(int start) {
		//(층수, 카운트)
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {start, 0});

		//층수 방문 여부 확인
		boolean[] visited = new boolean[F + 1];
		visited[start] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int stair = tmp[0];
			int cnt = tmp[1];

			if (stair == G) {
				result = Math.min(result, cnt);
				continue;
			}

			//위로 U층 이동
			if (stair + U <= F && !visited[stair + U]) {
				queue.add(new int[] {stair + U, cnt + 1});
				visited[stair + U] = true;
			}

			//아래로 D층 이동
			if (stair - D >= 1 && !visited[stair - D]) {
				queue.add(new int[] {stair - D, cnt + 1});
				visited[stair - D] = true;
			}

		}

	}

}
