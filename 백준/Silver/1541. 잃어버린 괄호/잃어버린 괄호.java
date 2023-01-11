//package boj.p1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * boj 1541 잃어버린 괄호 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램
 */
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] nums = str.split("\\-");//뺄샘 기준으로 분리
		int result = 0;

		//첫번째 숫자는 양수
		String[] plus = nums[0].split("\\+");
		
		for (int i = 0; i < plus.length; i++) {
			result += Integer.parseInt(plus[i]);
		}
		
		//다음 숫자부터는 빼주기
		for (int i = 1; i < nums.length; i++) {
			String[] tmp = nums[i].split("\\+");
			int sum = 0;
			for (int j = 0; j < tmp.length; j++) {
				sum += Integer.parseInt(tmp[j]);
			}
			result -= sum;
		}
		System.out.println(result);
	
	}
}
