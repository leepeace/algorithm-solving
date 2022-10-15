//package boj.p11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * boj 11053 가장 긴 증가하는 부분 수열
 * dp 문제
 * */
public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = solve(N, nums);
		System.out.println(result);
		
	}
	
	static int solve(int N, int[] nums) {
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {//현재의 직전 값까지 비교
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
}
