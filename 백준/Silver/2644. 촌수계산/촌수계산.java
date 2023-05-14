//package boj.p2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * boj 2644 촌수계산
 * */
public class Main {
	static int result;
	static LinkedList<LinkedList<Integer>> nodes;
	static int firstPeople;
	static int secondPeople;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		firstPeople = Integer.parseInt(st.nextToken());
		secondPeople = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		nodes = new LinkedList<>();
		result = -1;
		
		//초기화
		for (int i = 0; i <= n; i++) {
			nodes.add(new LinkedList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());//부모
			int y = Integer.parseInt(st.nextToken());//자식
			
			nodes.get(x).add(y);
			nodes.get(y).add(x);
		}
		
		solve(firstPeople, 0, new boolean[n+1]);
		
		
		System.out.println(result);
	}
	/*
	 * 주어진 입력 부모에서 시작하여 자식이 나올때까지 탐색, 만약 노드 끝까지 갔는데 입력 자식이 없다면 -1 
	 * @params now 현재 노드 
	 * @params cnt 촌수
	 * */
	static void solve(int now, int cnt, boolean[] check) {
		if(now == secondPeople) {//원하는 사람을 찾음
			result = cnt;
			return;
		}
		
		//인접한 노드 탐색
		check[now] = true;
		
		for (int i = 0; i < nodes.get(now).size(); i++) {
			if(!check[nodes.get(now).get(i)]) {//다음 노드를 방문하지 않은 경우
				solve(nodes.get(now).get(i), cnt+1, check);	
			}
		}
	}
	
	
}
