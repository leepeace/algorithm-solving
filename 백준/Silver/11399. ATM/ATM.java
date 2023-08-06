//package boj.p11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* boj 11399 ATM
* 출력 : 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력
* */
public class Main {
	public static void main(String[] args) throws IOException {
		int result = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inputs = new int[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputs);

		int[] sum = new int[N];

		sum[0] = inputs[0];

		for (int i = 1; i < N; i++) {
			sum[i] = sum[i-1] + inputs[i];
		}

		for (int i = 0; i < N; i++) {
			result += sum[i];
		}

		System.out.println(result);
	}
}
