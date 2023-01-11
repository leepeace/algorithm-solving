//package boj.p2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * boj 카드2
 *
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			if(queue.size() == 1) break;
			
			int data1 = queue.poll();
			int data2 = queue.poll();
			queue.add(data2);
		}
		int result = queue.poll();
		System.out.println(result);
	}
}
