//package p4008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author lee haemin
 * 9월 3주차 스터디
 * 문제 : 4008번 [모의 SW 역량테스트] 숫자 만들기
 * 문제 접근 방식 : 순열(연산자 순서)
 */
public class Solution {

	
	private static int N;//숫자의 개수
	private static int[] operation;//순서대로 '+', '-', '*', '/'의 개수
	private static int[] countOperation;
	private static int max, min;
	private static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			operation = new int[4];
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < operation.length; i++) {
				operation[i] = Integer.parseInt(st.nextToken());
			}
		
			countOperation = new int[4];
			
			num = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(new int[N-1], 0);

			bw.write("#" + test_case + " " + (max-min));
			bw.newLine();
		}//end of testcase
		
		bw.flush();
		bw.close();
	}
	
	
	//순열을 통해 연산자 순서를 정함
	private static void permutation(int[] output, int count) {
		if(count == N-1) {
			calculate(output);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operation[i] != 0 && countOperation[i] < operation[i]) {
				output[count] = i;
				countOperation[i]++;
				permutation(output, count+1);
				countOperation[i]--;
			}
		}
	}
	
	//연산자 순서를 토대로 사칙연산 수행
	private static void calculate(int[] output) { 
		int temp = num[0];
		
		for (int i = 0; i < output.length; i++) {
			//순서대로 '+', '-', '*', '/'
			if(output[i] == 0) {
				temp += num[i+1];
			}else if(output[i] == 1) {
				temp -= num[i+1];
			}else if(output[i] == 2) {
				temp *= num[i+1];
			}else {
				temp /= num[i+1];
			}
		}
		
		if(max < temp) {
			max = temp;
		}
		if(min > temp) {
			min = temp;
		}
	}

}
