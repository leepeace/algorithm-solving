//package boj.p17086;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * boj 아기 상어2
 * 출력 : 안전 거리의 최댓값
 * */
public class Main {
	
	static int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};//8방향
	static int[][] maps;
	static Queue<int[]> queue;
	static int N, M;
	static int[][] depths;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maps = new int[N][M];
		queue = new LinkedList<int[]>();
		int result = Integer.MIN_VALUE;
		depths = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(depths[i], Integer.MAX_VALUE);
		}
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if(maps[i][j] == 1) {//상어 위치 전부 넣음
					queue.add(new int[] {i, j});
					depths[i][j] = 0;
					solve(i, j);
				}
			}
		}
		
		result = Math.max(result, getMax());

		
		System.out.println(result);
	}
	

	static void solve(int startX, int startY) {
		boolean[][] visited = new boolean[N][M];
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];
			
			for(int dir = 0; dir < 8; dir++) {
				int nextX = nowX + deltas[dir][0];
				int nextY = nowY + deltas[dir][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
				
				//안전 거리가 기존 안전 거리보다 작으면 갱신  
				if(depths[nextX][nextY] > depths[nowX][nowY] + 1) {
					depths[nextX][nextY] = depths[nowX][nowY] + 1;
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY});	
				}
				
			}
		}
		
	}
	
	//가장 큰 안전거리를 구하는 함수
	static int getMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, depths[i][j]);
			}
		}
		return max;
	}
	
	
}
