import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], maxSize, result;
	static StringTokenizer st;
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] maxBlock;
	static boolean[][] isVisited;
	static boolean[][] isBlockVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		maxBlock = new boolean[N][N];
		result = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			int maxR = Integer.MIN_VALUE;
			int maxC = Integer.MIN_VALUE;
			int maxRainbow = Integer.MIN_VALUE;
			maxSize = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] >= 1) {
						Position temp = findBigBlock(r, c);
						if (temp.count >= 2 && temp.count >= maxSize) {
							if (temp.count == maxSize) {
								if (temp.countOfRainbow == maxRainbow) {
									if (temp.r == maxR) {
										if (temp.c < maxC) {
											continue;
										}
									} else if (temp.r < maxR)
										continue;
								}else if(temp.countOfRainbow < maxRainbow)
									continue;
							}
							maxSize = temp.count;
							maxC = temp.c;
							maxR = temp.r;
							maxRainbow = temp.countOfRainbow;
							maxBlock = isBlockVisited;
						}
					}
				}
			}
			if (maxSize < 2)
				break;
			result += (maxSize * maxSize);

			deleteBlock();
			setGravity();
			rotate();
			setGravity();
		}
		System.out.println(result);
	}

	private static void rotate() {
		int[][] copyOfMap = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				copyOfMap[N - c - 1][r] = map[r][c];
			}
		}
		map = copyOfMap;
	}

	private static void setGravity() {
		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {
				if (map[r][c] < 0)
					continue;
				int idx = r;
				while (idx < N - 1) {
					if (map[idx + 1][c] >= -1)
						break;
					map[idx + 1][c] = map[idx][c];
					map[idx][c] = -2;
					idx++;
				}
			}
		}
	}

	private static Position findBigBlock(int r, int c) {
		Queue<Position> q = new LinkedList<Position>();
		Position current = new Position(r, c, map[r][c], 0);
		q.offer(current);
		isBlockVisited = new boolean[N][N];
		int minR = r;
		int minC = c;
		int count = 0;
		int countOfRainbow = 0;
		while (!q.isEmpty()) {
			current = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = current.r + dir[d][0];
				int nc = current.c + dir[d][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isBlockVisited[nr][nc]) {
					if (map[nr][nc] == 0 || map[nr][nc] == current.value) {
						q.offer(new Position(nr, nc, current.value, current.count + 1));
						isBlockVisited[nr][nc] = true;
						if (map[nr][nc] != 0) {
							minR = nr < minR ? nr : minR;
							minC = nc < minC ? nc : minC;
						}

					}

				}
			}
		}
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (isBlockVisited[x][y]) {
					count++;
					if (map[x][y] == 0)
						countOfRainbow++;
				}
			}
		}
		current.r = minR;
		current.c = minC;
		current.count = count;
		current.setCountOfRainbow(countOfRainbow);
		return current;
	}

	private static void deleteBlock() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (maxBlock[r][c]) {
					map[r][c] = -2;
				}
			}
		}
	}

	private static class Position implements Comparable<Position> {
		int r;
		int c;
		int value;
		int count;
		int countOfRainbow;

		public Position(int r, int c, int value, int count) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
			this.count = count;
		}

		public void setCountOfRainbow(int countOfRainbow) {
			this.countOfRainbow = countOfRainbow;
		}

		@Override
		public int compareTo(Position o) {
			if (this.count == o.count) {
				if (o.r == this.r)
					return o.c - this.c;
				return o.r - this.r;
			}
			return this.count - o.count;
		}

	}

}
