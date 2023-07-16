//package boj.p19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * boj 19941 햄버거 분배
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String input = br.readLine();

		boolean[] visited = new boolean[N];
		int result = 0;

		for (int i = 0; i < input.length(); i++) {
			int idx = 0;
			if (input.charAt(i) == 'P') {
				idx = i;
			} else {
				continue;
			}

			int start = idx - K <= 0 ? 0 : idx - K;
			int end = idx + K >= N ? N - 1 : idx + K;

			for (int j = start; j <= end; j++) {
				if (input.charAt(j) == 'H' && !visited[j]) {
					result++;
					visited[j] = true;
					break;
				}
			}
		}

		//햄버거를 먹을 수 있는 최대 사람 수
		System.out.println(result);
	}
}
