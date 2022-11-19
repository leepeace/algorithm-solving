//package swea.p4193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] maps;
	static int C,D;//도착 위치
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			maps = new int[N][N];
			result = 0;
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			//시작 위치
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			solve(A, B);
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상하좌우
	
	static void solve(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {startX, startY, 0});
		
		boolean[][] visited = new boolean[N][N];
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];
			int nowTime = tmp[2];
			
			
			if(nowX == C && nowY == D) {
				result = nowTime;
				break;
			}
			for (int d = 0; d < dir.length; d++) {
				int nextX = nowX + dir[d][0];
				int nextY = nowY + dir[d][1];

				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY] || maps[nextX][nextY] == 1) continue;

				if(maps[nextX][nextY] == 2 && (nowTime % 3) != 2) {
					//현재 위치에서 대기해야 하므로, 현재 위치를 다시 큐에 넣음
					queue.add(new int[] {nowX, nowY, nowTime+1});	
				}else{
					//이동 가능한 경우
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY, nowTime + 1});
				}
			}
		
		}
		
		if(result == 0) result = -1;
		
	}
	
}
