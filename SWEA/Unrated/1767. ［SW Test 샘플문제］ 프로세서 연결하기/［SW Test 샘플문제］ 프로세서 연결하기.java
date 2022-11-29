//package ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] maps;
	static List<int[]> cores;
	static int maxCore;//최대 core
	static int result;//전선 길이 합
	static int totalCoreCnt;//입력으로 주어진 core 개수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			maps = new int[N][N];
			cores = new LinkedList<int[]>();
			maxCore = Integer.MIN_VALUE;
			totalCoreCnt = 0;
			result = Integer.MAX_VALUE;
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					
					if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;//가장자리는 리스트에 넣지않음
					if(maps[i][j] == 1) {
						cores.add(new int[] {i, j});
						totalCoreCnt++;
					}
				}
			}
			choice(0, 0);
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0,  1}};
	
	/**
	 * 부분집합으로 코어를 선택
	 * @param start
	 * @param cnt
	 */
	static void choice(int start, int cnt) {
		if(start >= totalCoreCnt) {
			//결과값 갱신
			if(cnt > maxCore) {
				maxCore = cnt;
				result = getLength();
			}else if(cnt == maxCore) {
				//만약 최대 코어 수가 같은 경우 전선 길이의 합이 최소인 것을 선택
				int len = getLength();
				result = Math.min(result, len);
			}			
			
			return;
		}
		
		//현재 코어 선택
		int[] tmp = cores.get(start);
		int nowX = tmp[0];
		int nowY = tmp[1];
		
		for (int d = 0; d < 4; d++) {
	
			//한 방향으로 끝까지 가보기(전선 연결)
			if(connect(d, nowX, nowY)) {
				//전선이 지나간곳은 방문체크를 위해 값 변경
				setStatus(2, nowX, nowY, d);
				//다음 코어 선택하러 가기(부분집합)
				choice(start+1, cnt+1);
				
				//원복시킴
				setStatus(0, nowX, nowY, d);				
			}
			
		}
			
		//현재 코어 미선택
		choice(start+1, cnt);
	}
	
	//전선을 끝까지 연결해보기
	static boolean connect(int dir, int nowX, int nowY) {
	
		int nextX = nowX;
		int nextY = nowY;
		
		while(true) {
			nextX += deltas[dir][0];
			nextY += deltas[dir][1];
					
			//전선을 끝까지 연결시킨 경우
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) return true;
			
			//다른 전선이나 코어를 만난 경우
			if(maps[nextX][nextY] == 1 || maps[nextX][nextY] == 2) return false;
		}
	
	}
	
	/**
	 * 전선이 지나간 자리를 다른 값으로 채워넣음
	 * @param status 0은 빈 셀, 1은 core, 2는  전선(내가 임의로 넣음)
	 * @param nowX
	 * @param nowY
	 */
	static void setStatus(int status, int nowX, int nowY, int dir) {
		int nextX = nowX;
		int nextY = nowY;
		
		while(true) {
			nextX += deltas[dir][0];
			nextY += deltas[dir][1];
					
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) break;
			
			maps[nextX][nextY] = status;
		}
	}
	
	static int getLength() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(maps[i][j] == 2) sum++;
			}
		}
		return sum;
	}
	
}

