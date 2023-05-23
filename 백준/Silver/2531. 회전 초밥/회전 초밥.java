//package boj.p2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * boj 2531 회전 초밥
 * */
public class Main {
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());// 접시 수
		int d = Integer.parseInt(st.nextToken());// 초밥 가짓수
		int k = Integer.parseInt(st.nextToken());// 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken());// 쿠폰 번호

		int[] maps = new int[n + k - 1];
		result = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			maps[i] = Integer.parseInt(br.readLine());
		}

		int j = 0;
		for (int i = n; i < maps.length; i++, j++) {
			maps[i] = maps[j];
		}

		int start = 0, end = k - 1;

		while (start < n && end < maps.length) {
			boolean[] visited = new boolean[d + 1];

			// start~end 사이의 초밥 번호가 중복된 번호가 있는지 확인
			int cnt = 0;
			for (int i = start; i <= end; i++) {
				if (!visited[maps[i]]) {
					visited[maps[i]] = true;
					cnt++;
				}
			}

			// 범위 사이의 초밥 번호가 중복되지 않은 경우

			if (!visited[c]) {
				result = Math.max(result, cnt + 1);
			} else {
				result = Math.max(result, cnt);
			}

			end++;
			start++;
		}

		System.out.println(result);
	}

}
