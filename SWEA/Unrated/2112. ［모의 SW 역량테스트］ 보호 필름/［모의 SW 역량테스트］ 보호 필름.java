//package swea.p2112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * swea 2112. [모의 SW 역량테스트] 보호 필름
 * */
public class Solution {
	
	static int D, W, K;
	static int result;
	static int[][] maps;
	static int[][] copyMaps;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			maps = new int[D][W];
			copyMaps = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					maps[i][j] = copyMaps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = K;
			
			if(K == 1) {
				result = 0;
				sb.append(String.format("#%d %d\n", tc, result));
				continue;
			}
			solve(0, 0);
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	//특성A는 0, 특성B는 1
	static void solve(int row, int cnt) {
		//기저조건 : 모든 세로 줄에 대해서 성능 검사
		if(check()) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(cnt >= result) return;//가지치기
		
		
		//가로 줄에 대해 A,B로 바꾸어봄
		for (int i = row; i < D; i++) {
			
			Arrays.fill(maps[i], 0);
			solve(i+1, cnt+1);
			
			Arrays.fill(maps[i], 1);
			solve(i+1, cnt+1);
			
			maps[i] = Arrays.copyOf(copyMaps[i], W);
		}
	}
	
	//성능 검사를 진행한다.
	static boolean check() {
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			boolean success = false;
			for (int r = 0; r < D-1; r++) {
				if(maps[r][c] == maps[r+1][c]) {
					cnt++;
				}else {	
					cnt = 1;
				}
				if(cnt == K) {
					success = true;
					break;
				}
			}
			if(!success) return false;
		}
		
		return true;
	}
	
	
	
}
