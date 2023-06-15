//package boj.p3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* boj 3273 두 수의 합
* */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] maps = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());

		int start = 0;
		int result = 0;

		// while (start < N){
		// 	if(sum == X){
		// 		result++;
		// 	}
		// 	if(sum > X || end == N){
		// 		sum -= maps[start];
		// 		start++;
		// 	}else{
		// 		sum += maps[end];
		// 		end++;
		// 	}
		// }

		for (int i = 0; i < N; i++) {
			int sum = 0;
			int end = i+1;

			while(end < N){
				sum = maps[i] + maps[end];

				if(sum == X){
					result++;
					break;
				}
				end++;
			}

		}


		System.out.println(result);
	}
}
