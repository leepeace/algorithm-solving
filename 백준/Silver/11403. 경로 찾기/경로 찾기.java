//package boj.p11403;

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
public class Main {
	private static int N;
	private static boolean[] visited;
	private static int[][] resultMatrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//정점의 개수
		
		visited = new boolean[N];
		
		resultMatrix = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					resultMatrix[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			for (int j = 0; j < N; j++) {
				if(resultMatrix[i][j] == 1 && !visited[j])
					search(i, j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	private static void search(int from, int to) {
		visited[to] = true;
		resultMatrix[from][to] = 1;
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && resultMatrix[to][i] == 1) search(from, i);

		}		
	}
	
}
