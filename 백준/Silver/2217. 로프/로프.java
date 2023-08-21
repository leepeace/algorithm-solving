//package boj.p2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
* boj 2217 로프
* */
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] inputs = new int[N];

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
			queue.add(inputs[i]);
		}

		int result = Integer.MIN_VALUE;
		int cnt = 1;
		while (!queue.isEmpty()){
			int value = queue.poll();
			result = Math.max(result, value * cnt);
			cnt++;
		}



		System.out.println(result);
	}
}
