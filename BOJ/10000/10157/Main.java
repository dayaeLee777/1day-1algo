import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, map[][], num, fillNum;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		num = Integer.parseInt(br.readLine());

		map = new int[R][C];
		fillNum = 1;
		fill(0, 0, R, C);

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == num)
					sb.append(c + 1).append(" ").append(r + 1);
			}
		}
		if (num > R * C || num <= 0)
			sb.append(0);

		System.out.println(sb.toString());
		br.close();
	}

	static void fill(int startR, int startC, int rSize, int cSize) {
		if (fillNum > R * C)
			return;

		for (int x = startR; x < startR + rSize; x++) {
			if (map[x][startC] == 0)
				map[x][startC] = fillNum++;
		}
		for (int y = startC + 1; y < startC + cSize - 1; y++) {
			if (map[startR + rSize - 1][y] == 0)
				map[startR + rSize - 1][y] = fillNum++;
		}
		for (int x = startR + rSize - 1; x > startR; x--) {
			if (map[x][startC + cSize - 1] == 0)
				map[x][startC + cSize - 1] = fillNum++;
		}
		for (int y = startC + cSize - 1; y > startC; y--) {
			if (map[startR][y] == 0)
				map[startR][y] = fillNum++;
		}

		fill(startR + 1, startC + 1, rSize - 2, cSize - 2);
	}
}

