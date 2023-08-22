//package boj.p2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* boj 2847 게임을 만든 동준이
* */
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] maps = new int[N];

		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(br.readLine());
		}

		int max = maps[N-1];

		int result = 0;

		for (int i = N-2; i >= 0; i--) {
			if(max-1 <= maps[i]){
				max--;
				result += maps[i] - max;
			}else{
				max = maps[i];
			}
		}

		System.out.println(result);
	}//end of main

}
