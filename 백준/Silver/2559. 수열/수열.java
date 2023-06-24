//package boj.p2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* boj 2559 수열
* */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] maps = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}
		//end input

		int start = 0, end = start + K;
		int result = Integer.MIN_VALUE;

		while(end <= N){
			int tmp = 0;
			for (int i = start; i < end; i++) {
				tmp += maps[i];
			}

			result = Math.max(result, tmp);
			start++;
			end++;
		}

		System.out.println(result);
	}
}
