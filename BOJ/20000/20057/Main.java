import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int[][][] spread = {
			{ { -2, 0 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -2 }, { 1, -1, }, { 1, 0 }, { 1, 1 }, { 2, 0 },
					{ 0, -1 } },
			{ { 0, -2 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { 2, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { 0, 2 },
					{ 1, 0 } },
			{ { 2, 0 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 2 }, { -1, 1, }, { -1, 0 }, { -1, -1 }, { -2, 0 },
					{ 0, 1 } },
			{ { 0, 2 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { -2, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 0, -2 },
					{ -1, 0 } } };

	static int[] ratio = { 2, 10, 7, 1, 5, 10, 7, 1, 2 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int length = 1;
		int r = N / 2;
		int c = N / 2;
		int d = 0;
		while (true) {
			if (count == 2) {
				count = 0;
				if (r > 0)
					length++;
			}

			for (int i = 0; i < length; i++) {
				r += dir[d][0];
				c += dir[d][1];

				if (map[r][c] > 0)
					tornado(r, c, d);
			}
			count++;
			d = (d + 1) % 4;

			if (r == 0 && c == 0)
				break;

		}
		System.out.println(result);
	}

	private static void tornado(int r, int c, int d) {
		int alpha = map[r][c];

		for (int s = 0; s < 9; s++) {

			int nr = r + spread[d][s][0];
			int nc = c + spread[d][s][1];
			int value = (map[r][c] * ratio[s]) / 100;
			alpha -= value;

			if (check(nr, nc)) {
				map[nr][nc] += value;
			} else {
				result += value;
			}
			
		}
		int nr = r + spread[d][9][0];
		int nc = c + spread[d][9][1];
		
		if (check(nr, nc)) {
			map[nr][nc] += alpha;
			map[r][c] = 0;
		} else
			result += alpha;
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		return false;
	}

}
