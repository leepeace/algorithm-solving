//package boj.p14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 14425 문자열 집합
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int result = 0;
		Map<String, Integer> maps = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			maps.put(tmp, 1);
		}
		
		String[] str = new String[M];
		
		for (int i = 0; i < M; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 0; i < M; i++) {
			if(maps.get(str[i]) != null) result++;
		}
		
		
		System.out.println(result);
	}
	
}
