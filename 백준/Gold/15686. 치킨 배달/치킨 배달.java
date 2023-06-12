//package boj.p15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * boj 15686 치킨 배달
 * */
public class Main {
	static int N;
	static int M;
	static int result;

	static LinkedList<int[]> chickenList = new LinkedList<>();
	static LinkedList<int[]> homeList = new LinkedList<>();

	static int[][] maps;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][N];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 2) {
					chickenList.add(new int[] {i, j});
				} else if (maps[i][j] == 1) {
					homeList.add(new int[] {i, j});
				}
			}
		}


		choice(0, new int[M], 0);

		System.out.println(result);
	}

	/*
	 * M개의 치킨집을 선택할 수 있는 경우의 수를 전부 구함
	 * */
	static void choice(int cnt, int[] output, int now) {
		//M개의 치킨 집 전부 구함
		if (cnt >= M) {
			getDistance(output);
			return;
		}

		//다음 치킨 집 선택
		for (int i = now; i < chickenList.size(); i++) {
			output[cnt] = i;
			choice(cnt + 1, output, i + 1);
		}
	}

	/*
	 * 선택한 치킨 집에 대해 도시의 치킨 거리 계산
	 * */
	static void getDistance(int[] output) {
		int sum = 0;

		for (int i = 0; i < homeList.size(); i++) {
			int min = Integer.MAX_VALUE;
			int[] home = homeList.get(i);
			int homeX = home[0], homeY = home[1];
			for (int j = 0; j < output.length; j++) {
				int[] tmp = chickenList.get(output[j]);
				int chickenX = tmp[0], chickenY = tmp[1];
				min = Math.min(min, Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY));
			}
			sum += min;
		}

		result = Math.min(result, sum);

	}

}
