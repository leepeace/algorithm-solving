//package boj.p16953;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* boj 16953 A → B
* */
public class Main {
	static int B, result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		solve(A, 0);

		System.out.println(result);
	}

	static void solve(long now, int cnt){
		if(now >= B){
			if(now == B){
				result = cnt + 1;
			}
			return;
		}

		solve(now * 2, cnt+1);//2를 곱함
		solve(now * 10 + 1, cnt+1);//1을 수의 가장 오른쪽에 추가

		if(result == 0) result = -1;
	}


}
