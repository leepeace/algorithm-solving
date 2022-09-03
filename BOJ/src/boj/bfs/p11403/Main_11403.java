package boj.bfs.p11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 : 11403 백준 경로 찾기(실버1)
 * 작성일 : 2022.08.30
 * */
public class Main_11403 {
	private static int N;
	private static LinkedList<LinkedList<Integer>> adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//정점의 개수
		
		adjList = new LinkedList<LinkedList<Integer>>();
		int[][] resultMatrix = new int[N][N];
		
		for(int i = 0; i <= N; i++) {
			adjList.add(new LinkedList<Integer>());
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					adjList.get(i).add(j);
					resultMatrix[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			search(i, resultMatrix);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	private static void search(int start, int[][] resultMatrix) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		boolean[] visited = new boolean[N+1];
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
			
			for(int i = 0; i < adjList.get(node).size(); i++) {
				if(!visited[adjList.get(node).get(i)]) {
					resultMatrix[node][i] = 1;
					queue.add(adjList.get(node).get(i));
				}else {
					resultMatrix[i][node] = 1;
				}
			}
		}
		
	}
	
}
