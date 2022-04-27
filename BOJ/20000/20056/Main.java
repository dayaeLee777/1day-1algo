import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, map[][], result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Fireball> list;
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList<Fireball>();

		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list.add(new Fireball(r - 1, c - 1, m, d, s));
		}

		while (K-- > 0) {
			moveFireball();
		}

		for (Fireball fireball : list) {
			result += fireball.m;
		}

		System.out.println(result);
	}

	private static void moveFireball() {

		map = new int[N][N];

		for (Fireball fireball : list) {
			int nr = (fireball.r + dir[fireball.d][0] * fireball.s) % N;
			int nc = (fireball.c + dir[fireball.d][1] * fireball.s) % N;

			if (nr < 0)
				nr = nr + N;

			if (nc < 0)
				nc = nc + N;

			fireball.move(nr, nc);
			map[nr][nc]++;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] >= 2) {
					int count = 0;
					int nm = 0;
					int ns = 0;
					int nd = -1; // 모두 홀수 1 또는 짝수면 2
					boolean flag = true; // 모두 통일 T, 다르면 F
					for (int i = list.size() - 1; i >= 0; i--) {
						Fireball fireball = list.get(i);
						if (fireball.r == r && fireball.c == c) {
							count++;
							nm += fireball.m;
							ns += fireball.s;
							if (nd == -1) {
								if (fireball.d % 2 == 0)
									nd = 2;
								else
									nd = 1;
							} else {
								if (flag && ((nd == 2 && fireball.d % 2 == 0) || (nd == 1 && fireball.d % 2 == 1)))
									flag = true;
								else
									flag = false;
							}
							list.remove(fireball);
						}
					}

					nm /= 5;
					ns /= count;
					if (nm > 0) {
						for (int f = 0; f < 4; f++) {
							if (flag)
								list.add(new Fireball(r, c, nm, f * 2, ns));
							else
								list.add(new Fireball(r, c, nm, f * 2 + 1, ns));
						}
					}
				}
			}
		}
	}

	private static class Fireball {
		int r;
		int c;
		int m;
		int d;
		int s;

		public Fireball(int r, int c, int m, int d, int s) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}

		public void move(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

}
