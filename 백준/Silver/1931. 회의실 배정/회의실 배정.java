import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
* boj 1931 회의실 배정
* */
public class Main{

	static class Time implements Comparable<Time>{
		int start, end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			return this.end == o.end ? this.start - o.start : this.end - o.end;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Time[] times = new Time[N];
		int result = 1;

		StringTokenizer st = null;
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			times[i] = new Time(s, e);
		}
	
		//회의가 빨리 끝나는 시간으로 정렬, 만약 끝나는 시간이 같으면 빨리 시작하는 순으로 정렬
		Arrays.sort(times);

		int checkTime = times[0].end;
		for(int i = 1; i < N; i++){
			if(checkTime <= times[i].start){
				result++;
				checkTime = times[i].end;
			}
		}

		System.out.println(result);
	}

}
