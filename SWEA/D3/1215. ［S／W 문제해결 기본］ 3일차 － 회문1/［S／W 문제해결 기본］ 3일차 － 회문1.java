
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1215. [S/W 문제해결 기본] 3일차 - 회문1
 * */
public class Solution {
	private static char[][] maps;
	static int result;
	private static int length;
	private static char[][] rotateMaps;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			length = Integer.parseInt(br.readLine());
			
			result = 0;
			int size = 8;
			maps = new char[size][size];
			rotateMaps = new char[size][size];//좌우반전
			
			for (int i = 0; i < size; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < size; j++) {
					maps[i][j] = tmp.charAt(j);
					rotateMaps[j][i] = maps[i][j];
				}
			}
			
			solve();
			
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}
	
	/*
	 * 거꾸로 뒤집어서 확인(좌우반전)
	 * */
	static void solve() {
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				if(j+length-1 < maps.length) {
					count(maps, i, j, length);
					count(rotateMaps, i, j, length);
				}
			}
		}
		
		
	}
	
    //좌우반전시킨 문자열이 같은 경우인지 확인한다
	static void count(char[][] arr, int row, int start, int size) {		
		String text = String.copyValueOf(arr[row], start, length);
		String rotate = new StringBuffer(text).reverse().toString();
		if(text.equals(rotate)) {
			result++;
		}
	}
	
	
}
