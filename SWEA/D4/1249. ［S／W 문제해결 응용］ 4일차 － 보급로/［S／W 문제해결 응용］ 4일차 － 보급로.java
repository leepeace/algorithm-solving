//package swea.p1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	
	static int[][] maps;
	static int result;
	static int N;
	static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			maps = new int[N][N];
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					maps[i][j] = tmp.charAt(j)-'0';
				}
			}
		
			solve(0, 0);
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	static class Node implements Comparable<Node>{
		int x,y;
		int value;
		
		public Node(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	
	static void solve(int startX, int startY) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		queue.add(new Node(startX, startY, 0));
		
		int endX = N-1, endY = N-1;
		boolean[][] visited = new boolean[N][N];
		int[][] depths = new int[N][N];//경로에 대한 합 저장
		depths[startX][startY] = maps[startX][startY];

		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowValue = now.value;
			
			visited[nowX][nowY] = true;
			
			if(nowX == endX && nowY == endY) {
				result = Math.min(result, depths[nowX][nowY]);
				continue;
			}
			
			for (int d = 0; d < dir.length; d++) {
				int nextX = nowX + dir[d][0];
				int nextY = nowY + dir[d][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
				
				//이미 방문한 경우 이미 저장되었던 값과 탐색할 경로의 새로운 값을 비교하여 더 작은 값을 넣음
				if(visited[nextX][nextY]) {
					if(depths[nextX][nextY] > nowValue + maps[nextX][nextY]) {
						depths[nextX][nextY] = nowValue + maps[nextX][nextY];
						queue.add(new Node(nextX, nextY, depths[nextX][nextY]));		
					}
				}else {
					depths[nextX][nextY] = nowValue + maps[nextX][nextY];
					queue.add(new Node(nextX, nextY, depths[nextX][nextY]));					
				}
				
			}
			
		}
		
	}
	
}
