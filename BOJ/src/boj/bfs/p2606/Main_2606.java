package boj.bfs.p2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 : 백준 2606 바이러스
 * 작성일 : 2022.08.30
 * */
public class Main_2606 {
	
	private static LinkedList<LinkedList<Integer>> list;
	private static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vertex = Integer.parseInt(br.readLine());//컴퓨터의 수
		int edge = Integer.parseInt(br.readLine());//컴퓨터 쌍의 수
		
		list = new LinkedList<LinkedList<Integer>>();
		visited = new boolean[vertex+1];
		
		//list 초기화
		for (int i = 0; i <= vertex; i++) {
			list.add(new LinkedList<Integer>());
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		bfs(vertex);
		
		//시작 노드 1번 제외 방문한 노드를 카운트하기 위해 인덱스 2부터 시작
		//방문한 노드는 연결된 노드이다.
		int count = 0;
		for (int i = 2; i < visited.length; i++) {
			if(visited[i]) count++;
		}
		
		System.out.println(count);
		
	}//end of main
	private static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);//1번 노드부터 시작
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			visited[nowNode] = true;
			
			for (int i = 0; i < list.get(nowNode).size(); i++) {
				//현재 노드와 인접한 노드들 중에서 방문하지 않은 노드를 방문함 
				if(!visited[list.get(nowNode).get(i)]) {
					queue.add(list.get(nowNode).get(i));
				}
			}
		}
		
	}
	
}
