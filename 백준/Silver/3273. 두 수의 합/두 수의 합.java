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

		int result = 0;

		//1차 풀이
		// for (int i = 0; i < N; i++) {
		// 	int sum = 0;
		// 	int end = i+1;
		//
		// 	while(end < N){
		// 		sum = maps[i] + maps[end];
		//
		// 		if(sum == X){
		// 			result++;
		// 			break;
		// 		}
		// 		end++;
		// 	}
		// }

		Arrays.sort(maps);
		int start = 0, end = N-1;

		while (start < end){
			if(maps[start] + maps[end] == X){
				start++;
				end--;
				result++;
			}else if(maps[start] + maps[end] > X){
				end--;
			}else{
				start++;
			}
		}


		System.out.println(result);
	}
}
