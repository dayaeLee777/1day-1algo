import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R, map[][], result, count;
	static StringTokenizer st;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] isVisted, countVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		result = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		checkCloseCountry();
		System.out.println(result);
	}

	private static void checkCloseCountry() {
		while (true) {
			isVisted = new boolean[N][N];
			boolean existCloseCount = false;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (!isVisted[n][m]) {
						count = 0;
						int sum = getSum(n, m);
						if (count > 1) {
							calcMoving(sum);
							existCloseCount = true;
						}
					}
				}
			}
			if (!existCloseCount)
				return;

			result++;
		}
	}

	private static void calcMoving(int sum) {

		int average = sum / count;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (countVisited[n][m]) {
					map[n][m] = average;
				}
			}
		}
	}

	private static int getSum(int n, int m) {

		countVisited = new boolean[N][N];
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(n, m));
		int sum = map[n][m];
		isVisted[n][m] = true;
		countVisited[n][m] = true;
		count++;

		while (!q.isEmpty()) {
			Node current = q.poll();
			int cn = current.r;
			int cm = current.c;

			for (int d = 0; d < 4; d++) {
				int nn = cn + dir[d][0];
				int nm = cm + dir[d][1];

				if (nn >= 0 && nn < N && nm >= 0 && nm < N && !isVisted[nn][nm]) {
					int diff = Math.abs(map[cn][cm] - map[nn][nm]);
					if (diff >= L && diff <= R) {
						q.offer(new Node(nn, nm));
						sum += map[nn][nm];
						isVisted[nn][nm] = true;
						countVisited[nn][nm] = true;
						count++;
					}
				}
			}
		}
		return sum;
	}

	private static class Node {
		int r;
		int c;

		public Node() {
			super();
		}

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
