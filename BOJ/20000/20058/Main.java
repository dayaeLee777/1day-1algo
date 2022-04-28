import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, Q, size, map[][], result, maxValue, Llist[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		size = (int) Math.pow(2, N);
		map = new int[size][size];
		Llist = new int[Q];
		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int q = 0; q < Q; q++)
			Llist[q] = Integer.parseInt(st.nextToken());

		for (int q = 0; q < Q; q++) {
			isVisited = new boolean[size][size];
			rotate(Llist[q]);
			minusIce();
		}
		result = 0;
		getResult();
		System.out.println(result);
		maxValue = maxValue == Integer.MIN_VALUE ? 0 : maxValue;
		System.out.println(maxValue);
	}

	private static void minusIce() {
		maxValue = Integer.MIN_VALUE;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] > 0 && !isVisited[r][c])
					findIce(r, c);
			}
		}
	}

	private static void getResult() {

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] != 0) {
					result += map[r][c];
				}
			}
		}
	}

	private static void findIce(int r, int c) {

		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(r, c));
		int count = 1;
		isVisited[r][c] = true;
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dir[d][0];
				int nc = cur.y + dir[d][1];

				if (nr >= 0 && nr < size && nc >= 0 && nc < size && !isVisited[nr][nc] && map[nr][nc] != 0) {
					isVisited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
					count++;
				}
			}
		}
		maxValue = Math.max(maxValue, count);
	}

	private static void rotate(int L) {
		int r = 0;
		int c = 0;
		int length = (int) Math.pow(2, L);
		int[][] copyMap = new int[size][size];
		while (r < size) {
			c = 0;
			while (c < size) {
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < length; j++) {
						copyMap[r + j][c + length - i - 1] = map[r + i][c + j];
					}
				}
				c += length;
			}
			r += length;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int count = 0;
				if (copyMap[i][j] != 0) {

					for (int d = 0; d < 4; d++) {
						int ni = i + dir[d][0];
						int nj = j + dir[d][1];
						if (ni >= 0 && ni < size && nj >= 0 && nj < size && copyMap[ni][nj] > 0) {
							count++;
						}
					}
					if (count < 3) {
						map[i][j] = copyMap[i][j] - 1;
					} else
						map[i][j] = copyMap[i][j];
				} else
					map[i][j] = copyMap[i][j];
			}

		}
	}

	private static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}

