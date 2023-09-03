//package boj.p20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * boj 20291 파일 정리
 * */
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] inputs = new String[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = br.readLine();
		}

		Map<String, Integer> resultsMap = new HashMap<>();

		//'.'을 기준으로 자르기
		for (int i = 0; i < N; i++) {
			String[] tmp = inputs[i].split("\\.");

			resultsMap.put(tmp[1], resultsMap.getOrDefault(tmp[1], 0) + 1);
		}

		//파일 확장자명을 리스트에 담아서 정렬
		List<String> output = new ArrayList<>(resultsMap.keySet());
		Collections.sort(output);

		for(String file : output){
			System.out.println(file + " " + resultsMap.get(file));
		}

	}//end of main

}
