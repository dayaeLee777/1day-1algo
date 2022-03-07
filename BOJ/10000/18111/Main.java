import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M, B, max, map[][], time;
	static Integer[] count;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		count = new Integer[257];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		flat();
		System.out.println(time + " " + max);
	}

	public static void flat() {
		time = 0;
		while (true) {
			max = 0;
			int maxCount = 0;

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[n][m] > max) {
						max = map[n][m];
						maxCount = 0;
					}
					if (map[n][m] == max)
						maxCount++;
				}
			}
			if (maxCount == N * M)
				break;

			if (max == 256)
				decreaseH(max);
			else if (maxCount > N * M / 2) {
				if (N * M - maxCount <= B)
					increaseH(max);
				else
					decreaseH(max);
			} else {
				decreaseH(max);
			}
		}
	}

	private static void increaseH(int max) {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] != max) {
					map[n][m]++;
					time += 1;
				}
			}
		}
	}

	private static void decreaseH(int max) {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == max) {
					map[n][m]--;
					time += 2;
				}
			}
		}
	}
}
