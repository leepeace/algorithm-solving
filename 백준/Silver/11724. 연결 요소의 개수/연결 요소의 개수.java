//package boj.p11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
* boj 11724 연결 요소의 개수
* */
public class Main{
	static LinkedList<LinkedList<Integer>> inputs = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		for (int i = 0; i < N+1; i++) {
			inputs.add(new LinkedList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			//무방향
			inputs.get(u).add(v);
			inputs.get(v).add(u);
		}

		int result = 0;
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]){
				solve(i, visited);
				result++;
			}
		}

		System.out.println(result);
	}//end of main

	static void solve(int now, boolean[] visited){
		//현재 방문한 노드를 방문처리함
		visited[now] = true;


		for (int i = 0; i < inputs.get(now).size(); i++) {
			if(!visited[inputs.get(now).get(i)]){
				visited[inputs.get(now).get(i)] = true;
				solve(inputs.get(now).get(i), visited);
			}
		}
	}


}
