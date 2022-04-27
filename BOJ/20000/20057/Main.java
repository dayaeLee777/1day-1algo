package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] spread = { 
			{}
			{ -2, 0 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -2 }, { 1, -1, }, { 1, 0 }, { 1, 1 }, { 2, 0 } ,
			{ -2, 0 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, 2 }, { 1, 1, }, { 1, 0 }, { 1, -1 }, { 2, 0 }};

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
		int length = 1;
		int r = N / 2;
		int c = N / 2;
		while (length <= N) {
			if (r == 0 && c == 0)
				break;
			int idx = length;
			while (idx > 0) {
				r--;
				idx--;
				tornado(r, c, 3);
			}

		}

		System.out.println(result);
	}

	private static void tornado(int r, int c, int d) {
		if (map[r][c] == 0)
			return;

	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		return false;
	}

}
