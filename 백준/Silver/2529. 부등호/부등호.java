//package boj.p2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * boj 2529 부등호
 * */
public class Main {
	
	static String[] maps;
	static int k;
	static String max, min;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		maps = new String[k];
		max = Long.MIN_VALUE + "";
		min = Long.MAX_VALUE + "";
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			maps[i] = st.nextToken();
		}
	 	
		solve(0, new int[k+1], new boolean[10]);
		
		sb.append(max + "\n");
		sb.append(min + "\n");
		
		System.out.println(sb);
	}
	
	/*
	 * 숫자 모든 경우의 수를 확인함
	 * */
	static void solve(int cnt, int[] output, boolean[] visited) {
		if(cnt == k+1) {
			//해당 숫자에 대해 부등호를 만족하는 지 확인함
			if(operation(output)) {
				//만족한다면 최댓값, 최솟값 갱신	
				long tmp = Long.parseLong(parseArray(output));
				max = Long.parseLong(max) < tmp ? parseArray(output) : max;
				min = Long.parseLong(min) > tmp ? parseArray(output) : min;
			}
			
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[cnt] = i;
				solve(cnt+1, output, visited);
				visited[i] = false;
			}
			
		}
		
	}
	
	/*
	 * 부등호를 만족하는 지 확인함
	 * */
	static boolean operation(int[] output) {
		
		for (int i = 0; i < k; i++) {
			if(">".equals(maps[i])) {
				if(output[i] < output[i+1]) {
					return false;
				}
			}else {// "<"인 경우
				if(output[i] > output[i+1]) {
					return false;
				}
			}
		}		
		return true;
	}
	
	static String parseArray(int[] output) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < output.length; i++) {
			sb.append(output[i]);
		}
		
		return sb.toString();
	}
	
}
