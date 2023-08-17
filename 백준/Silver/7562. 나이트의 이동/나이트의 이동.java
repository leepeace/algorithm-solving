//package boj.p7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int I;//한변의 길이
	static int moveX, moveY;//이동하려는 위치

	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			I = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			//현재 위치
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			moveX = Integer.parseInt(st.nextToken());
			moveY = Integer.parseInt(st.nextToken());

			result = 0;

			solve(nowX, nowY);

			System.out.println(result);
		}

	}//end of main

	static int[][] dir = {
		{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
		{1, -2}, {2, -1}, {2, 1}, {1, 2}};

	static void solve(int startX, int startY){
		boolean[][] visited = new boolean[I][I];
		visited[startX][startY] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startX, startY, 0});


		while (!queue.isEmpty()){
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];
			int nowMoveCnt = tmp[2];

			if(nowX == moveX && nowY == moveY){
				result = nowMoveCnt;
				break;
			}

			for (int d = 0; d < dir.length; d++) {
				int nextX = nowX + dir[d][0];
				int nextY = nowY + dir[d][1];

				if(nextX < 0 || nextX >= I || nextY < 0 || nextY >= I || visited[nextX][nextY]) continue;

				visited[nextX][nextY] = true;
				queue.add(new int[]{nextX, nextY, nowMoveCnt+1});
			}
		}

	}


}
