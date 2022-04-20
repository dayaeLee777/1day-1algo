import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], copyMap[][], sum;
	static StringTokenizer st;
	static boolean isVisited[][][];
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isVisited = new boolean[N][M][4];
		sum = Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		copyMap = map;
		setWalls(0);

		System.out.println(sum);
	}

	private static void setWalls(int count) {
		if (count >= 3) {
			getCountOfSafeArea();
			return;
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (copyMap[n][m] == 0) {
					copyMap[n][m] = 1;
					setWalls(count + 1);
					copyMap[n][m] = 0;
				}
			}
		}

	}

	private static void getCountOfSafeArea() {
		Queue<Pos> sq = new LinkedList<Pos>();
		int[][] virusMap = new int[N][M];

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				virusMap[n][m] = copyMap[n][m];
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (virusMap[n][m] == 2) {
					sq.offer(new Pos(n, m));
				}
			}
		}

		while (!sq.isEmpty()) {
			Pos curPos = sq.poll();
			for (int d = 0; d < 4; d++) {
				int nx = curPos.getX() + dir[d][0];
				int ny = curPos.getY() + dir[d][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && virusMap[nx][ny] == 0) {
					virusMap[nx][ny] = 3;
					sq.offer(new Pos(nx, ny));
				}
			}
		}

		int result = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (virusMap[n][m] == 0) {
					result++;
				}
			}
		}
		sum = Math.max(sum, result);
	}

	private static class Pos {
		int x;
		int y;

		public Pos() {
			super();
		}

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}
}
