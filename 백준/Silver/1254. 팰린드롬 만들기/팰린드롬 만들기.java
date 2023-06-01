//package boj.p1254;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * boj 1254 팰린드롬 만들기
 * */
public class Main {
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		result = 0;

		solve(str);

		System.out.println(result);
	}

	static void solve(String input){
		StringBuilder tmp = new StringBuilder().append(input);
		if(input.equals(tmp.reverse().toString())){
			result = input.length();
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			StringBuilder sb = new StringBuilder(input);
			String subStr = input.substring(0, i);

			sb.append(new StringBuilder().append(subStr).reverse());//문자열을 뒤집어서 붙이기

			String check = sb.toString();
			if(check.equals(sb.reverse().toString())){
				result = sb.length();
				return;
			}
		}

	}




}
