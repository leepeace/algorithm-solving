//package boj.p4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* boj 4963 섬의 개수
* */
public class Main{
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	static int[][] maps;
	static int w,h;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true){
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if(w == 0 && h == 0) break;

			maps = new int[h][w];
			result = 0;


			boolean[][] visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			//bfs search
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					//방문하지 않은 섬을 방문
					if(!visited[i][j] && maps[i][j] == 1){
						solve(i, j, visited);
					}
				}
			}

			System.out.println(result);
		}//end of while


	}//end of main

	/*
	* startX,startY : 시작위치
	* visited : 섬 방문 여부 확인
	* */
	static void solve(int startX, int startY, boolean[][] visited){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startX, startY});
		visited[startX][startY] = true;
		result++;

		while (!queue.isEmpty()){
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];

			//인접한 섬 확인
			for (int d = 0; d < dir.length; d++) {
				int nextX = nowX + dir[d][0];
				int nextY = nowY + dir[d][1];

				if(nextY < 0 || nextX < 0 || nextX >= h || nextY >= w || visited[nextX][nextY]) continue;

				if(maps[nextX][nextY] == 1){
					queue.add(new int[]{nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}

	}


}
