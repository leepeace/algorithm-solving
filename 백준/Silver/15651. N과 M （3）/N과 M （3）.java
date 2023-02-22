import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 문제 : N과 M (3)
 * */
public class Main {
	static int N, M;
	static int result;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		solve(new int[M], 1, 0);

		bw.flush();
	}
	
	
	/**
	 * @param output 중복 순열 결과값 저장
	 * @param start 시작 위치
	 * @param cnt 개수 카운트
	 * @throws IOException 
	 */
	static void solve(int[] output, int start, int cnt) throws IOException {
		if(cnt == M) {//M개를 고름
			for (int i = 0; i < M; i++) {
				bw.write(output[i] + " ");
			}
			bw.newLine();
			
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			output[cnt] = i;
			solve(output, i, cnt+1);
		}
		
	}
	
	
}
