//package boj.p18310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* boj 18310 안테나
* */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] maps = new int[N];

		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(maps);

		int result = N%2 == 0 ? maps[(N/2)-1] : maps[N/2];
		System.out.println(result);
	}
}
