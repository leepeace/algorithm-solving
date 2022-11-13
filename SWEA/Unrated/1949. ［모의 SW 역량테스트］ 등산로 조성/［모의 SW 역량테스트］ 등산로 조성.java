//package swea.p1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * swea 1949. [모의 SW 역량테스트] 등산로 조성
 * */
public class Solution {

	static int N;
	static int K;
	static boolean[][] visited;
	static int[][] maps;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			maps = new int[N][N];
			result = Integer.MIN_VALUE;
			visited = new boolean[N][N];

			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, maps[i][j]);
				}
			}

			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max == maps[i][j]) {//가장 높은 봉우리 좌표 큐에 저장
						solve(i, j, false, 1);
					}
				}
			}
			

			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우

	
	/**
	 * @param nowX
	 * @param nowY
	 * @param height 현재 위치의 높이
	 * @param flag 지형을 깍았는지 확인
	 */
	static void solve(int nowX, int nowY, boolean flag, int lengthCnt) {
		result = Math.max(result, lengthCnt);
		
		visited[nowX][nowY] = true;
		
	    for (int i = 0; i < dir.length; i++) {
	        int nextX = nowX + dir[i][0];
	        int nextY = nowY + dir[i][1];
	        
	        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]) continue;

	    
	        if(maps[nextX][nextY] < maps[nowX][nowY]) {//이동 가능한 높이
	        	solve(nextX, nextY, flag, lengthCnt+1);
	        }else if(!flag && maps[nextX][nextY] - K < maps[nowX][nowY]) {//지형의 높이가 이동 조건에 해당하지 않는 경우 지형을 깍고, flag를 true
	        	int tmp = maps[nextX][nextY];
	        	maps[nextX][nextY] = maps[nowX][nowY] - 1;//현재 지형 - 1 만큼만 깍으면 됨
	        	solve(nextX, nextY, true, lengthCnt+1);
	        	maps[nextX][nextY] = tmp;
	        }
	    }
	    
	    visited[nowX][nowY] = false;
	}
	
	
}

