//package boj.p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* boj 2493 탑
* */
public class Main {
	static int[] results, maps;
	static Stack<int[]> stack;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maps = new int[N];
		results = new int[N];
		stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}


		solve();

		Arrays.stream(results).forEach(n-> System.out.print(n + " "));
	}

	static void solve(){
		for (int i = 0; i < N; i++) {
			int now = maps[i];
			while(!stack.isEmpty()){
				if(stack.peek()[0] > now) break;
				stack.pop();
			}
			results[i] = stack.isEmpty() ? 0 : stack.peek()[1];
			stack.push(new int[]{now, i+1});
		}
	}

}
