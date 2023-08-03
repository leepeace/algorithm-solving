//package boj.p1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hashMap = new HashMap<>();
		int result = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			hashMap.put(input, 1);
		}


		List<String> output = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if(hashMap.get(input) != null){
				result++;
				output.add(input);
			}
		}

		Collections.sort(output);

		System.out.println(result);

		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}


	}
}
