import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static StringTokenizer st;
	static Time[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		array = new Time[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			array[n] = new Time(start, end);
		}
		Arrays.sort(array);

		int maxTime = 0;
		int count = 0;

		for (int n = 0; n < N; n++) {
			if (maxTime <= array[n].startTime) {
				count++;
				maxTime = array[n].endTime;
			}
		}

		System.out.print(count);
		br.close();
	}

	private static class Time implements Comparable<Time> {
		int startTime;
		int endTime;

		public Time() {
			super();
		}

		public Time(int startTime, int endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Time o) {
			if (o.endTime == this.endTime)
				return this.startTime - o.startTime;
			return this.endTime - o.endTime;
		}

	}
}