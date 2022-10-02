//package swea.p1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	private static int result;
	private static int N;
	private static boolean[][] visited;
	private static int[][] maps;
	
	static class Point implements Comparable<Point>{
		int x,y;
		int value;		

		public Point(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			maps = new int[N][N];	
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					maps[i][j] = tmp.charAt(j) - '0';
				}
			}
			
			result = Integer.MAX_VALUE;
			
			solve();
			
			sb.append(String.format("#%d %d\n", test_case, result));
		}
		System.out.println(sb.toString());
	}
	
	private static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};//좌우상하
	
	private static void solve() {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.add(new Point(0, 0, maps[0][0]));
		
		int[][] sum = new int[N][N];//경로 합
		sum[0][0] = maps[0][0];
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowValue = now.value;
			
			visited[nowX][nowY] = true;
			
			if(nowX == N-1 && nowY == N-1) {
				result = Math.min(result, nowValue);
				continue;
			}
			
			for (int i = 0; i < dir.length; i++) {
				int nextX = nowX + dir[i][0];
				int nextY = nowY + dir[i][1];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if(visited[nextX][nextY]) {
					//이미 방문한 경우 현재 진행할 경로와 이미 방문했던 경로를 비교해 현재 진행할 경로가 더 작은 경우 큐에 삽입
					if(nowValue + maps[nextX][nextY] < sum[nextX][nextY]) {
						sum[nextX][nextY] = nowValue + maps[nextX][nextY];
						queue.add(new Point(nextX, nextY, sum[nextX][nextY]));						
					}			
				}else {					
					sum[nextX][nextY] = nowValue + maps[nextX][nextY];
					queue.add(new Point(nextX, nextY, sum[nextX][nextY]));
				}
			}
		}
		
	}
	
}

