//package boj.p13164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
* boj 13164 행복 유치원
* */
public class Main {
	static int K;//조의 개수
	static int N;//원생의 수

	static int[] maps;

	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		maps = new int[N];
		result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}

		//오름차순 정렬
		Arrays.sort(maps);


		solve();

		System.out.println(result);
	}//end of main

	static void solve(){
		List<Integer> groupList = new ArrayList<>();

		//각 인접한 원생의 차이를 구해줌
		for (int i = 0; i < maps.length-1; i++) {
			groupList.add(maps[i+1]-maps[i]);
		}

		//오름차순 정렬
		Collections.sort(groupList);

		//k개의 그룹을 만들기 위해서는 N-K개만큼 원생을 합치면 됨
		for (int i = 0; i < N-K; i++) {
			result += groupList.get(i);
		}
	}
}
