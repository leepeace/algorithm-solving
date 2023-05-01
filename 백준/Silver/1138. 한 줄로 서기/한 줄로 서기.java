//package boj.p1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * boj 1138 한 줄로 서기
 * */
public class Main {
	private static int N;
	private static int[] maps;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		maps = new int[N];
		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0, new int[N], new boolean[N]);
		
	}
	
	/*
	 * 나올수있는 자리 조합을 만들고, 입력 정보와 카운트가 일치하는지 확인함
	 * */
	static void solve(int start, int cnt, int[] output, boolean[] visited) {
		if(cnt == N) {
			if(getCountLeft(output)) {
				Arrays.stream(output).forEach(n -> System.out.print(n+1 + " "));
			}
		
			return;
		}
		
		for (int i = 0; i < N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[cnt] = i;
				solve(i+1, cnt+1, output, visited);
				visited[i] = false;
			}
		}
		
	}
	
	/*
	 * 왼쪽에 키 큰 사람이 몇 명 있는지 확인
	 * */
	static boolean getCountLeft(int[] output) {
		int[] cnt = new int[N];
		
		for(int i = N-1; i >= 0; i--) {
			int leftCnt = 0;
			for (int j = i-1; j >= 0; j--) {
				if(output[i] < output[j]) {
					leftCnt++;
				}
			}
			cnt[output[i]] = leftCnt;
		}

		for (int i = 0; i < N; i++) {
			if(cnt[i] != maps[i]) return false; 
		}
		
		return true;
	}
	
}
