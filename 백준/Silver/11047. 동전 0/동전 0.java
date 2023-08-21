//package boj.p11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* boj 11047 동전 0
* */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] maps = new int[N];

		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(br.readLine());
		}

		//동전 개수를 최소로 하려면 동전을 큰 것부터 소비하면 된다.
		int result = 0;
		for (int i = N-1; i >= 0; i--) {
			if(K - maps[i] >= 0){
				result += (K / maps[i]);
				K -= maps[i] * (K / maps[i]);
			}
		}

		System.out.println(result);
	}//end of main
}
