//package boj.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj 1260
 *
 */
public class Main{
	private static LinkedList<Integer>[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		node = new LinkedList[N+1];
		
		for (int i = 0; i <= N; i++) node[i] = new LinkedList<>();
	
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			//간선 양방향
			node[x].add(y);
			node[y].add(x);
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs(V, N);
		
		
	}
	
	static void dfs(int V, boolean[] visited) {

		visited[V] = true;
		System.out.print(V + " ");
		
		//인접한 정점에 방문해야 함
		for (int i = 0; i < node[V].size(); i++) {
			Collections.sort(node[V]);
			if(visited[node[V].get(i)]) continue;
			dfs(node[V].get(i), visited);
		}
	}
	
	static void bfs(int V, int N) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		visited[V] = true;
		queue.add(V);
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			System.out.print(data + " ");			
			
			for (int i = 0; i < node[data].size(); i++) {
				if(visited[node[data].get(i)]) continue;
				Collections.sort(node[data]);
				visited[node[data].get(i)] = true;
				queue.add(node[data].get(i));
			}
			
		}
	}
	
}
