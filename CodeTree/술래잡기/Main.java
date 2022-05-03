import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H, K, result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean bunker[][];
	static List<Theif> theifList;
	static Finder finder;
	static int[][] tDir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][][] fDir = { { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } },
			{ { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bunker = new boolean[N][N];
		theifList = new ArrayList<Theif>();
		finder = new Finder((N - 1) / 2, (N - 1) / 2, 0, 0, 0, 1, 0, false);

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			theifList.add(new Theif(x, y, d));
		}

		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			bunker[x][y] = true;
		}

		for (int k = 1; k <= K; k++) {
			moveThief();
			moveFinder();
			catchThief(k);
		}
		System.out.println(result);

	}

	private static void catchThief(int k) {
		int x = finder.x;
		int y = finder.y;
		int d = finder.d;
		int turn = finder.turn;

		int idx = 0;
		int count = 0;
		while (idx++ < 3) {
			for (int t = theifList.size() - 1; t >= 0; t--) {
				Theif theif = theifList.get(t);
				if (!vaildCheck(x, y))
					continue;
				if (bunker[theif.x][theif.y])
					continue;
				if (x == theif.x && y == theif.y) {
					count++;
					theifList.remove(t);
				}
			}
			x += fDir[turn][d][0];
			y += fDir[turn][d][1];
		}
		result += k * count;

	}

	private static void moveFinder() {
		int x = finder.x;
		int y = finder.y;
		int d = finder.d;
		int turn = finder.turn;
		int count = finder.count;
		int idx = finder.idx;
		int length = finder.length;

		x += fDir[turn][d][0];
		y += fDir[turn][d][1];

		if (x == 0 && y == 0) {
			turn = 1;
			count = 0;
			idx = 0;
			finder.zero = true;
			length = N - 1;
			d = 0;
		} else if (x == (N - 1) / 2 && y == (N - 1) / 2) {
			turn = 0;
			count = 0;
			idx = 0;
			length = 1;
			d = 0;
		} else {

			idx++;

			if (idx == length) {
				if (finder.zero) {
					finder.setZero(false);
				} else {
					count++;
					if (count == 2) {
						if (turn == 0) {
							length++;
						} else if (turn == 1) {
							length--;
						}
						count = 0;
					}
				}
				idx = 0;
				d = (d + 1) % 4;
			}
		}

		finder.setFinder(x, y, d, turn, count, length, idx);
	}

	private static void moveThief() {
		find: for (Theif theif : theifList) {
			if (closeTheif(theif)) {
				int dir = theif.d;
				while (true) {
					int nx = theif.x + tDir[dir][0];
					int ny = theif.y + tDir[dir][1];

					if (vaildCheck(nx, ny)) {
						if (nx == finder.x && ny == finder.y)
							continue find;
						theif.move(nx, ny, dir);
						continue find;
					}
					dir = (dir + 2) % 4;
				}
			}
		}

	}

	private static boolean vaildCheck(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= N)
			return false;
		return true;
	}

	private static boolean closeTheif(Theif theif) {
		int distance = Math.abs(theif.x - finder.x) + Math.abs(theif.y - finder.y);
		if (distance <= 3)
			return true;
		return false;
	}

	private static class Theif {
		int x;
		int y;
		int d;

		public Theif(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		private void move(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	private static class Finder {
		int x;
		int y;
		int d;
		int turn;
		int count;
		int length;
		int idx;
		boolean zero;

		public Finder(int x, int y, int d, int turn, int count, int length, int idx, boolean zero) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.turn = turn;
			this.count = count;
			this.length = length;
			this.idx = idx;
			this.zero = zero;
		}

		private void setFinder(int x, int y, int d, int turn, int count, int length, int idx) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.turn = turn;
			this.count = count;
			this.length = length;
			this.idx = idx;
		}

		public void setZero(boolean zero) {
			this.zero = zero;
		}

	}

}