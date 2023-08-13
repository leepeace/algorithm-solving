//package boj.p2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
* boj 2583 영역 구하기
* */
public class Main {
	static int M,N,K;
	static LinkedList<Integer> results = new LinkedList<>();

	static int[][] maps;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		boolean[][] visitied = new boolean[M][N];
		maps = new int[M][N];


		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					maps[j][k] = 1;//직사각형 범위 안을 1로 세팅
				}
			}

		}

		int totalCnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visitied[i][j] && maps[i][j] != 1){
					solve(i, j, visitied);
					totalCnt++;
				}
			}
		}

		System.out.println(totalCnt);

		Collections.sort(results);

		for (int i = 0; i < results.size(); i++) {
			System.out.printf(results.get(i) + " ");
		}
	}//end of main

	static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static void solve(int startX, int startY, boolean[][] visited){
		Queue<int[]> queue = new LinkedList<>();
		int areaCnt = 0;

		queue.add(new int[]{startX, startY});
		visited[startX][startY] = true;
		areaCnt++;

		while (!queue.isEmpty()){
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];

			for (int d = 0; d < dir.length; d++) {
				int nextX = nowX + dir[d][0];
				int nextY = nowY + dir[d][1];

				//배열의 범위를 넘어서는지 확인
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextX][nextY]) continue;

				if(maps[nextX][nextY] != 1){
					visited[nextX][nextY] = true;
					queue.add(new int[]{nextX, nextY});
					areaCnt++;
				}
			}
		}

		results.add(areaCnt);
	}

}
