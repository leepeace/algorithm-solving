//package boj.p12015;

import java.util.Arrays;
import java.util.Scanner;

/*
 * boj 12015 가장 긴 증가하는 부분 수열2
 * dp 이진탐색
 * */
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(dp, 0, size, nums[i]);
			if(idx >= 0) continue;
			
			int insertIdx = Math.abs(idx)-1;
			dp[insertIdx] = nums[i];
			
			if(size == insertIdx) size++;
		}
		
		System.out.println(size);
	}
}
