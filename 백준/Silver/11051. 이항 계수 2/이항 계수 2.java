//package boj.p11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * boj 11051 이항계수2
 * dp문제
 * 이항 계수 :  n개의 원소에서 k개의 원소를 뽑아내는 경우, 이때 아무것도 뽑지않았거나, 전부 뽑은 경우는 1이다.
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			int end = Math.min(i, K);
			for (int j = 0; j <= end; j++) {
				if(j == 0 || j == i) dp[i][j] = 1%10007;
				else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
			}
		}
		
		System.out.println(dp[N][K]);

	}
}
