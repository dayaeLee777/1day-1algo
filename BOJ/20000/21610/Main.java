import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], d[], s[];
	static StringTokenizer st;
	static int dir[][] = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
	static boolean cloud[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		cloud = new boolean[N][N];
		d = new int[M];
		s = new int[M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = N - 1; r >= N - 2; r--) {
			for (int c = 0; c <= 1; c++) {
				cloud[r][c] = true;
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			d[m] = Integer.parseInt(st.nextToken());
			s[m] = Integer.parseInt(st.nextToken());
			vivaragi(m);
		}
		System.out.println(getSum());
	}

	private static void vivaragi(int idx) {
		int moveR = dir[d[idx] - 1][0] * s[idx];
		int moveC = dir[d[idx] - 1][1] * s[idx];

		moveR = moveR >= 0 ? moveR % N : (moveR % N) + N;
		moveC = moveC >= 0 ? moveC % N : (moveC % N) + N;

		for (int mr = 0; mr < N - moveR; mr++) {
			boolean[] flag = cloud[0];
			for (int r = 0; r < N - 1; r++) {
				cloud[r] = cloud[r + 1];
			}
			cloud[N - 1] = flag;
		}
		for (int mc = 0; mc < N - moveC; mc++) {
			for (int r = 0; r < N; r++) {
				boolean flag = cloud[r][0];
				for (int c = 0; c < N - 1; c++) {
					cloud[r][c] = cloud[r][c + 1];
				}
				cloud[r][N - 1] = flag;
			}
		}

		rainInCloud();
		copyWaterBug();
		setCloud();
	}

	static private void rainInCloud() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (cloud[r][c])
					map[r][c]++;
			}
		}
	}

	static private void copyWaterBug() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (cloud[r][c]) {
					int count = 0;
					for (int d = 1; d < 8; d += 2) {
						int nr = r + dir[d][0];
						int nc = c + dir[d][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 0) {
							count++;
						}
					}
					map[r][c] += count;
				}

			}
		}
	}

	static private void setCloud() {
		boolean[][] copyOfCloud = cloud;
		cloud = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] >= 2 && !copyOfCloud[r][c]) {
					cloud[r][c] = true;
					map[r][c] -= 2;
				}
			}
		}

	}

	private static int getSum() {
		int result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0)
					continue;
				result += map[r][c];
			}
		}
		return result;
	}

}
