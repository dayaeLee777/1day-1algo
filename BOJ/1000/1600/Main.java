import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, R, C, area[][], cnt, res;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean isVisited[][][];
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 8번
	static int[][] jump = { { 2, 1 }, { 1, 2 }, { 1, -2 }, { 2, -1 }, { -2, 1 }, { -1, 2 }, { -2, -1 }, { -1, -2 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());	// W
		R = Integer.parseInt(st.nextToken());	// H

		isVisited = new boolean[R][C][K+1];
		area = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				area[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		res = -1;
		move();
		
		System.out.println(res);

		br.close();
	}

	private static void move() {
		Queue<Point> q = new LinkedList<Point>();
		isVisited[0][0][0] = true;
		q.offer(new Point(0, 0, 0, 0));

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			if (tmp.x == R - 1 && tmp.y == C - 1) {
				res = tmp.mcnt;
				return;
			}

			if (tmp.hcnt < K) {
				for (int j = 0; j < 8; j++) {
					int nx = tmp.x + jump[j][0];
					int ny = tmp.y + jump[j][1];
					if (checkvisit(nx, ny, tmp.hcnt+1)) {
						isVisited[nx][ny][tmp.hcnt+1] = true;
						q.offer(new Point(nx, ny, tmp.mcnt + 1, tmp.hcnt+1));
					}
				}
			}
			for (int d = 0; d < 4; d++) {
				int nx = tmp.x + dir[d][0];
				int ny = tmp.y + dir[d][1];

				if (checkvisit(nx, ny, tmp.hcnt)) {
					isVisited[nx][ny][tmp.hcnt] = true;
					q.offer(new Point(nx, ny, tmp.mcnt + 1, tmp.hcnt));
				}
			}
			
		}
	}

	private static boolean checkvisit(int x, int y, int h) {
		if (x >= 0 && y >= 0 && x < R && y < C && !isVisited[x][y][h] && area[x][y] == 0)
			return true;
		else
			return false;
	}

	private static class Point {
		int x;
		int y;
		int mcnt;
		int hcnt;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int mcnt) {
			super();
			this.x = x;
			this.y = y;
			this.mcnt = mcnt;
		}

		public Point(int x, int y, int mcnt, int hcnt) {
			super();
			this.x = x;
			this.y = y;
			this.mcnt = mcnt;
			this.hcnt = hcnt;
		}
		
		
	}
}

