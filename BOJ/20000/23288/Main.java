import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, map[][], result, d;
	static StringTokenizer st;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] isVisited;
	static Cube cube;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = 0;
		d = 1;
		cube = new Cube(1, 6, 2, 5, 4, 3);
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		Position movingPosition = new Position(0, 0);
		while (K-- > 0) {
			movingPosition = move(movingPosition);
			switch (d) {
			case 0:
				cube.moveNorth();
				break;
			case 1:
				cube.moveEast();
				break;
			case 2:
				cube.moveSouth();
				break;
			case 3:
				cube.moveWest();
				break;
			}
			result += getScore(movingPosition);
		}
		System.out.println(result);
	}

	private static void setDir(int value) {
		if (cube.bottom > value) {
			d = (d + 1) % 4;
		} else if (cube.bottom < value) {
			d = (d + 3) % 4;
		}
	}

	private static int getScore(Position movingPosition) {
		isVisited = new boolean[N][M];
		Queue<Position> q = new LinkedList<Position>();

		int value = map[movingPosition.r][movingPosition.c];
		q.offer(movingPosition);
		isVisited[movingPosition.r][movingPosition.c] = true;
		int count = 1;
		while (!q.isEmpty()) {
			Position cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dir[d][0];
				int nc = cur.c + dir[d][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && value == map[nr][nc]) {
					isVisited[nr][nc] = true;
					q.offer(new Position(nr, nc));
					count++;
				}
			}
		}

		setDir(value);
		return count * value;
	}

	private static Position move(Position pos) {
		int nr = pos.r + dir[d][0];
		int nc = pos.c + dir[d][1];

		if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
			d = (d + 2) % 4;
			nr = pos.r + dir[d][0];
			nc = pos.c + dir[d][1];
		}
		return new Position(nr, nc);
	}

	private static class Cube {
		int up;
		int bottom;
		int north;
		int south;
		int west;
		int east;

		public Cube(int up, int bottom, int north, int south, int west, int east) {
			super();
			this.up = up;
			this.bottom = bottom;
			this.north = north;
			this.south = south;
			this.west = west;
			this.east = east;
		}

		public void moveNorth() {
			int temp = up;
			up = south;
			south = bottom;
			bottom = north;
			north = temp;
		}

		public void moveSouth() {
			int temp = up;
			up = north;
			north = bottom;
			bottom = south;
			south = temp;
		}

		public void moveWest() {
			int temp = up;
			up = east;
			east = bottom;
			bottom = west;
			west = temp;
		}

		public void moveEast() {
			int temp = up;
			up = west;
			west = bottom;
			bottom = east;
			east = temp;
		}

		@Override
		public String toString() {
			return "Cube [up=" + up + ", bottom=" + bottom + ", north=" + north + ", south=" + south + ", west=" + west
					+ ", east=" + east + "]";
		}

	}

	private static class Position {
		int r;
		int c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}

	}
}
