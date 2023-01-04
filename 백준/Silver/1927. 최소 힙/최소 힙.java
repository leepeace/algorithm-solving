//package boj.p1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			}else {
				pq.add(x);
			}
		}
		System.out.println(sb);
	}
}
