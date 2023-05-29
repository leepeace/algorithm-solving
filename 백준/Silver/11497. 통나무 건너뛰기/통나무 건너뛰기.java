//package boj.p11497;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* boj 11497 통나무 건너뛰기
* */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < T; tc++){
			int N = Integer.parseInt(br.readLine());

			int[] maps = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i = 0; i < N; i++){
				maps[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(maps);

			int[] answers = new int[N];
			answers[N/2] = maps[N-1];

			int leftIdx = 0, rightIdx = N-1;
			for (int i = 0; i < N; i++) {
				if(i % 2 == 0){
					answers[leftIdx++] = maps[i];
				}else{
					answers[rightIdx--] = maps[i];
				}
			}
			
			int result = Math.abs(answers[N-1] - answers[0]);
			for (int i = 0; i < N-1; i++) {
				result = Math.max(result, Math.abs(answers[i+1] - answers[i]));
			}

			System.out.println(result);
		}
	}

}
