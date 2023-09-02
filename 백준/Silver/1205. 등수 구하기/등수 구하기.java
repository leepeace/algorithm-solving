//package boj.p1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* boj 1205 등수 구하기
* */
public class Main{
	public static void main(String[] args) throws Exception{
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] inputsArr = new int[N];
		int result = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.add(newScore);

		if(N > 0) st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			inputsArr[i] = Integer.parseInt(st.nextToken());
			queue.add(inputsArr[i]);
		}

		int cnt = 1;
		int before = -1;

		while (!queue.isEmpty()){
			int value = queue.poll();

			//중복된 점수가 아닌경우
			if(value == newScore && before != value){
				result = cnt;
				before = value;
			}

			if(cnt > P && before == value){
				result = -1;
				break;
			}
			cnt++;
		}


		System.out.println(result);
	}
}
