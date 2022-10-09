//package boj.p17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * boj 17472 다리 만들기2
 * 출력 : 모든 섬을 연결하는 다리 길이의 최솟값, 모든 섬을 연결하는 것이 불가능하면 -1
 * */
public class Main{

	static int[][] maps;
	static int N, M;
	static int[][] depths;//그룹핑된 섬 정보 저장
	static boolean[][] visited;
	static int[][] paths;
	
	static int[] parents;//부모 인덱스
	
	
	static class Node implements Comparable<Node> {
		int from, to, weight;

		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}


		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		depths = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//1. 각 섬을 구분하기 위한 섬 그룹핑
		int groupCnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && maps[i][j] == 1) {
					grouping(i, j, groupCnt);
					groupCnt++;
				}
			}
		}
		
		
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(depths[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		//2. 각 섬 사이의 다리 길이를 구함
		paths = new int[groupCnt][groupCnt];//다리 길이 저장
		
		for (int i = 1; i < groupCnt; i++) {
			Arrays.fill(paths[i], Integer.MAX_VALUE);
		}
		
		searchAllPath();
		
		/*for (int i = 1; i < groupCnt; i++) {
			for (int j = 1; j < groupCnt; j++) {
				System.out.print("(" + i + "," + j + ") = " + paths[i][j] + " ");
			}
			System.out.println();
		}*/
		
		//3. MST를 통해 최소 다리 길이를 구함
		ArrayList<ArrayList<Node>> lists = new ArrayList<>();
		
		for (int i = 1; i < groupCnt; i++) {
			lists.add(new ArrayList<Node>());
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		for (int from = 1; from < groupCnt; from++) {
			for (int to = 1; to < groupCnt; to++) {
				if(paths[from][to] == Integer.MAX_VALUE) continue;
				pq.add(new Node(from, to, paths[from][to]));
			}
		}
		
		int result = 0;
		
		make(groupCnt);

		int size = pq.size();
		int connectCnt = 1;
		for (int i = 0; i < size; i++) {
			Node node = pq.poll();
			if(find(node.from) != find(node.to)) {//다리를 연결 시킴
				result += node.weight;
				union(node.from, node.to);
				connectCnt++;
			}
		}
		
		//연결되지 않는 경우도 확인		
		if(connectCnt != groupCnt-1 || result == 0)
			result = -1;
			
		System.out.println(result);
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우

	// 섬에 대한 그룹핑
	static void grouping(int r, int c, int groupNum) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int nowX = tmp[0];
			int nowY = tmp[1];

			if (visited[nowX][nowY])
				continue;

			depths[nowX][nowY] = groupNum;

			visited[nowX][nowY] = true;
			for (int i = 0; i < dir.length; i++) {
				int nextX = nowX + dir[i][0];
				int nextY = nowY + dir[i][1];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
				if (visited[nextX][nextY]) continue;

				if (maps[nextX][nextY] == 1) {
					depths[nextX][nextY] = groupNum;
					queue.add(new int[] { nextX, nextY });
				}
			}
		}
	}

	
	//각 섬간의 길이를 구함
	static void searchAllPath() {
		int from = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(depths[r][c] == 0) continue;
				from = depths[r][c];	
				connect(from, r, c);
			}
		}
		
	}
	
	//다리 연결 시킴
	static void connect(int from, int r, int c) {
		int cnt = 0;
		for (int nc = c+1; nc < M; nc++) {
			int to = depths[r][nc];
			if(to == 0) cnt++;
			else if(to == from) {
				if(cnt > 0) break;
				else continue;
			}
			else if(to != from){//다른 섬을 만난 경우
				if(cnt <= 1) break;//다리길이는 2 이상 
				paths[from][to] = Math.min(paths[from][to], cnt);
				paths[to][from] =  Math.min(paths[from][to], cnt);
				break;
			}
		}
		
		//열
		cnt = 0;
		for (int nr = r+1; nr < N; nr++) {
			int to = depths[nr][c];
			if(to == 0) cnt++;
			else if(to == from) {
				if(cnt > 0) break;
				else continue;
			}
			else if(to != from){
				if(cnt <= 1) break;
				paths[to][from] = Math.min(paths[to][from], cnt);
				paths[from][to] = Math.min(paths[to][from], cnt);
				break;
			}
		}
	}
	
	

	
	///////////////////크루스칼 알고리즘////////////////////////////////
	
	static void make(int groupCnt) {
		parents = new int[groupCnt];
		for (int i = 1; i < groupCnt; i++) {//자기 자신을 부모로 설정
			parents[i] = i;
		}
	}
	
	static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		
		if(a_root == b_root) return false;
		
		parents[b_root] = a_root;
		
		return true;
	}
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	
	
}
/*
 * 
 * 다리는 바다에만 건설, 다리 길이 2 이상, 다리 방향은 가로 또는 세로 놓을 수 있는 다리 놓아보기-> 사이클 여부 확인. 최소 간선이
 * n-1개 1->0 인 곳이 땅의 끝 가로 : 같은 행, 세로 : 같은 열 섬에 대한 그룹핑 i->j로 가는 길에 대한 카운트
 */

/*
7 8
0 0 0 0 0 0 1 1
1 1 0 0 0 0 1 1
1 1 0 0 0 0 0 0
1 1 0 0 0 1 1 0
0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1

 * */
