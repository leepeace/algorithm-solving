//package boj.p1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* boj 1439 뒤집기
* */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int reverseZero = 0, reverseOne = 0;

		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '0'){
				for (int j = i+1; j < input.length(); j++) {
					if(input.charAt(j) != input.charAt(i)) {
						i = j;
						break;
					}
				}
				reverseZero++;
			}
		}

		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '1'){
				for (int j = i+1; j < input.length(); j++) {
					if(input.charAt(j) != input.charAt(i)) {
						i = j;
						break;
					}
				}
				reverseOne++;
			}
		}

		int result = Math.min(reverseZero, reverseOne);

		System.out.println(result);
	}
}
