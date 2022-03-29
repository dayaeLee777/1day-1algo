import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.Attributes.Name;

public class Main {

	static int N, M, r, c, d, map[][], result;
	static StringTokenizer st;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		move(r, c, d);
		System.out.println(result);
	}

	private static void move(int r, int c, int d) {

		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(r, c, d));

		go: while (!q.isEmpty()) {
			Pos current = q.poll();
			int cr = current.r;
			int cc = current.c;
			int cd = current.d;

			if (map[cr][cc] == 0) {
				result++;
				map[cr][cc] = 2;
			}

			for (int i = 0; i < 4; i++) {

				cd = (cd + 3) % 4;
				int nr = cr + dir[cd][0];
				int nc = cc + dir[cd][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					q.offer(new Pos(nr, nc, cd));
					continue go;
				}
			}
			int nr = cr + dir[(cd + 2) % 4][0];
			int nc = cc + dir[(cd + 2) % 4][1];
			if (map[nr][nc] != 1) {
				q.offer(new Pos(nr, nc, cd));
			} else {
				return;
			}

		}
	}

	private static class Pos {
		int r;
		int c;
		int d;

		public Pos() {
			super();
		}

		public Pos(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}
}
