//package swea.p2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * swea 2105. [모의 SW 역량테스트] 디저트 카페
 * */
public class Solution {
	static int N;
	static int[][] maps;
	static int result;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			maps = new int[N][N];
			result = Integer.MIN_VALUE;
			isSelected = new boolean[101];
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solve(i, j, 0, i, j, 0);
				}
			}
			if(result == Integer.MIN_VALUE) result = -1;
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	static int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	

	static void solve(int nowX, int nowY, int d, int endX, int endY, int cnt){
		//도착
		if(nowX == endX && nowY == endY && d == 3) {
			if(cnt <= 2) return;
			//결과값 갱신
			result = Math.max(result, cnt);                                                                                                                                                    
			return;
		}
				
		
		//디저트 방문 체크
		
		for (int i = d; i < dir.length; i++) {			
			//다음 위치로 이동
			int nextX = nowX + dir[i][0];
			int nextY = nowY + dir[i][1];
			
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isSelected[maps[nextX][nextY]]) continue;

			isSelected[maps[nextX][nextY]]= true;
			solve(nextX, nextY, i, endX, endY, cnt+1);
			isSelected[maps[nextX][nextY]]= false;
		}
		
	}
	
	
}