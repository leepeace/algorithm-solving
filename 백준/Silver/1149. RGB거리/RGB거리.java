//package boj.p1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * boj rgb 거리
 * dp
 * */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int col = 3;
		int[][] maps = new int[N][col];
		
		for (int i = 0; i < maps.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][col];
		dp[0][0] = maps[0][0]; dp[0][1] = maps[0][1]; dp[0][2] = maps[0][2];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < col; j++) {
				if(j == 0) {//빨강->초록,파랑 가능
					dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2]) + maps[i][j];
				}else if(j == 1) {//초록->빨강, 파랑 가능
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + maps[i][j];
				}else {//파랑->초록, 빨강 가능
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + maps[i][j];
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < col; i++) {
			result = Math.min(result, dp[N-1][i]);
		}
		
		System.out.println(result);
	}
}
/*
 * 현재 선택한 색깔 값 + 그 전 선택  
 * 
 * */
 