//package swea.p1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int N;
	static int B;
	static int result;
	static int[] height;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			result = Integer.MAX_VALUE;
			
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0);
			sb.append(String.format("#%d %d\n", tc, Math.abs(result-B)));
		}
		System.out.println(sb);
	}
	
	static void solve(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					sum += height[i];
				}
			}
			if(sum >= B) {
				result = Math.min(result, sum);
			}
			return;
		}
		
		visited[cnt] = true;
		solve(cnt+1);
		
		visited[cnt] = false;
		solve(cnt+1);
	}
	
}
