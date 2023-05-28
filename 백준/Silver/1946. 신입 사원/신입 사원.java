//package boj.p1946;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


/*
* boj 1946 신입 사원
* */
public class Main {

	static class Score implements Comparable<Score>{
		int firstScore;//서류 성적
		int secondScore;//면접 성적

		public Score(int firstScore, int secondScore) {
			this.firstScore = firstScore;
			this.secondScore = secondScore;
		}

		@Override
		public int compareTo(Score o) {
			return this.firstScore - o.firstScore;//서류 성적으로 정렬
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		for(int tc = 0; tc < T; tc++){
			int N = Integer.parseInt(br.readLine());
			Score[] scores = new Score[N];

			for (int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				scores[i] = new Score(s1, s2);
			}

			Arrays.sort(scores);

			int result = 1;
			int max = scores[0].secondScore;
			
			for (int i = 1; i < N; i++){
				if(max > scores[i].secondScore){
					result++;
					max = scores[i].secondScore;
				}
			}

			System.out.println(result);
		}


	}

}
