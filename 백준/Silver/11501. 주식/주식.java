//package boj.p11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * boj 11501 주식 
 * */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	
			
			int[] maps = new int[N];
			long result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				maps[i] = Integer.parseInt(st.nextToken());
			}
			result = solve(maps, result, N);
			
			sb.append(String.format("%d\n", result));
		}
		System.out.println(sb.toString());
	}
	
	
	static long solve(int[] maps, long result, int N) {
		long max = 0;
		for (int i = N-1; i >= 0; i--) {
			if(max > maps[i]) {//수익을 낼 수 있는 경우
				result += max - maps[i];
			}else {
				max = maps[i];
			}
		}
		
		return result;
	}
	
}
