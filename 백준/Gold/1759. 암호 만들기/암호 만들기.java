//package boj.p1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
* boj 1759 암호 만들기
* */
public class Main {
	static int L, C;
	static LinkedList<Character> alphabet = new LinkedList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	static char[] input;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		input = new char[C];

		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(input);

		sb = new StringBuilder();
		solve(0, new boolean[C], new int[L], 0);

		String[] results = sb.toString().split("\n");


		Arrays.stream(results).forEach(s -> System.out.println(s));
	}

	static void solve(int totalCnt, boolean[] visited, int[] output, int now){
		if(totalCnt == L){
			//조합된 문자열이 모음 1개, 자음 2개를 포함하는지 확인
			String concatTxt = concat(output);
			if(check(concatTxt) && increaseCheck(concatTxt)){
				sb.append(concatTxt);
				sb.append("\n");
			}
			return;
		}

		for (int i = now; i < C; i++) {
			if(!visited[i]){
				visited[i] = true;
				output[totalCnt] = i;
				solve(totalCnt+1, visited, output, i);
				visited[i] = false;
			}
		}

	}

	static String concat(int[] output){
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < output.length; i++) {
			builder.append(input[output[i]]);
		}

		return builder.toString();
	}

	static boolean check(String txt){
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < txt.length(); i++) {
			if(alphabet.contains(txt.charAt(i))){
				cnt1++;
			}else{
				cnt2++;
			}
		}
		if(cnt1 >= 1 && cnt2 >= 2) return true;

		return false;
	}

	static boolean increaseCheck(String txt){
		for (int i = 0; i < txt.length()-1; i++) {
			if(txt.charAt(i) > txt.charAt(i+1)) return false;
		}
		return true;
	}
}
