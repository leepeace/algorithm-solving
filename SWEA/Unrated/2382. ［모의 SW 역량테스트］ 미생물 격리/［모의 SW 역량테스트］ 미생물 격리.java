
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * swea 2382. [모의 SW 역량테스트] 미생물 격리
 * 시뮬레이션 
 * */
public class Solution {
	
	static class Node implements Comparable<Node>{
		int x,y;
		int cnt;//미생물 수
		int direction;//이동 방향(상: 1, 하: 2, 좌: 3, 우: 4)
		
		public Node(int x, int y, int cnt, int direction) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.direction = direction;
		}
		
		@Override
		public int compareTo(Node o) {
			return o.cnt - this.cnt;
		}
		
	}
	
	static int N,M,K;
	static List<Node> node;
	static int[][] maps;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
	
			N = Integer.parseInt(st.nextToken());//셀의 개수
			M = Integer.parseInt(st.nextToken());//격리 시간
			K = Integer.parseInt(st.nextToken());//미생물 군집의 개수
			
			node = new LinkedList<Node>();
			maps = new int[N][N];//미생물 충돌 여부 확인을 위한 배열
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				node.add(new Node(row, col, cnt, dir));
				maps[row][col] = i;
			}
			
			
			solve();
			int result = getRemainCount();
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	static int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상하좌우
	
	static void solve() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(int time = 0; time < M; time++) {
			//모든 군집을 전부 이동시킴
			for (int i = 0; i < node.size(); i++) {
				Node now = node.get(i);
				int nowDir = now.direction;
				maps[now.x][now.y] = 0;
				
				int nextX = now.x + dir[nowDir][0];
				int nextY = now.y + dir[nowDir][1];
					
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
					
				//가장 자리의 빨간 셀인 경우 방향 전환 및 미생물 절반 죽음
				if(nextX == 0 || nextX == N-1 || nextY == 0 || nextY == N-1) {
					now.cnt /= 2;
					now.direction = changeDir(nowDir);
				}
				now.x = nextX;
				now.y = nextY;
					
				pq.add(now);
				
			}
			
			node.clear();
			
			//충돌하는 군집 합치기
			while(!pq.isEmpty()) {
				Node tmp = pq.poll();

				if(maps[tmp.x][tmp.y] == 0) {
					node.add(tmp);
					maps[tmp.x][tmp.y] = node.size();
				}else {//충돌하는 경우
					node.get(maps[tmp.x][tmp.y]-1).cnt += tmp.cnt;
				}
			}
		}
		
		
	}
	
	
	static int changeDir(int direction) {
		if(direction == 1) {
			return 2;
		}else if(direction == 2) {
			return 1;
		}else if(direction == 3) {
			return 4;
		}else {
			return 3;
		}
	}
	
	
	static int getRemainCount() {
		int sum = 0;
		for (int i = 0; i < node.size(); i++) {
			sum += node.get(i).cnt;
		}
		return sum;
	}

}

