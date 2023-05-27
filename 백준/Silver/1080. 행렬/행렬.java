//package boj.p1080;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * boj 1080 행렬
 * */
public class Main {
	static int[][] mapA;
	static int[][] mapB;
	static int result;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		mapA = new int[n][m];
		mapB = new int[n][m];

		result = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				mapA[i][j] = tmp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				mapB[i][j] = tmp.charAt(j) - '0';
			}
		}
		solve();

		System.out.println(result);
	}//end of main

	static void solve() {
		int cnt = 0;
		boolean sameMap = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check()) {
					sameMap = true;
					break;
				}
				if (mapA[i][j] != mapB[i][j] && i + 2 < n && j + 2 < m) {
					//3*3행렬을 뒤집어야 함
					reverseMap(i, j);
					cnt++;
				}
			}
		}
		result = sameMap ? Math.min(result, cnt) : -1;
	}

	/*
	 * 3 * 3 행렬을 반대로 뒤집음
	 * */
	static void reverseMap(int row, int col) {
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				mapA[i][j] = mapA[i][j] == 0 ? 1 : 0;
			}
		}
	}

	/*
	 * A와 B 행렬이 일치하는지 확인함
	 * */
	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mapA[i][j] != mapB[i][j])
					return false;
			}
		}
		return true;
	}

}
