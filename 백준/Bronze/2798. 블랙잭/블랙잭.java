//package boj.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj 2798 블랙잭
 * 출력 : M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력
 */
public class Main {
	static int result;
	private static int M;
	private static int N;
	private static int[] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		
		solve(0, 0, 0);
		
		System.out.println(result);
	}
	
	static void solve(int cnt, int start, int sum) {
		if(cnt >= 3) {
			if(sum <= M) {
				result = Math.max(result, sum);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			solve(cnt+1, i+1, sum+cards[i]);
		}
		
	}
	
}
