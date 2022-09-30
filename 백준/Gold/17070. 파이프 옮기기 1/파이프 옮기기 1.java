//package boj.p17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * boj 17070 파이프 옮기기1
 * 2022.09.30
 * 출력 : 파이프의 한쪽 끝을 (N,N)로 이동시키는 방법의 개수
 * */
public class Main {
	
	private static int N;
	private static int[][] maps;
	private static boolean[][] visited;
	private static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		maps = new int[N][N];
		visited = new boolean[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][1] = true;//시작 위치 
		solve(0, 1, 0);
		
		System.out.println(result);
	}
	

	
	private static int[][] dir = {{0, 1}, {1, 0}, {1, 1}};//오른쪽, 아래, 대각선
	
	//갈 수 있는 방향에 대한 인덱스 저장
	private static int[][] types = {
			{0, 2},//가로
			{1, 2},//세로
			{0, 1, 2}//대각선
	};
	
	
	/**
	 * @param count
	 * @param row
	 * @param col
	 * @param nowType 0=가로, 1=세로, 2=대각선
	 */
	private static void solve(int row, int col, int nowType) {
		if(row == N - 1 && col == N - 1) {
			/*for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited.length; j++) {
					System.out.print(visited[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("-----------------");*/
			result++;
			return;
		}
		
		
		
		int nextX = 0;
		int nextY = 0;
	
		for (int i = 0; i < types[nowType].length; i++) {
			nextX = row + dir[types[nowType][i]][0];
			nextY = col + dir[types[nowType][i]][1];
			
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
			if(visited[nextX][nextY]) continue;
		
			//빈칸 조건 확인
			if(maps[nextX][nextY] == 1) {
				continue;
			}
			if(types[nowType][i] == 2) {
				if(maps[nextX-1][nextY] == 1 || maps[nextX][nextY-1] == 1) {
					continue;
				}
			}
			visited[nextX][nextY] = true;
			solve(nextX, nextY, types[nowType][i]);
			visited[nextX][nextY] = false;
		}
	}
	
	
	
}
