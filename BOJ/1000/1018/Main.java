import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int result, N, M, cu;
	static StringTokenizer st;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		result = Integer.MAX_VALUE;

		for (int n = 0; n < N; n++) {
			String temp = br.readLine();
			for (int m = 0; m < M; m++) {
				if (temp.charAt(m) == 'B')
					map[n][m] = true;
				else
					map[n][m] = false;
			}
		}

		for (int n = 0; n < N - 7; n++) {
			for (int m = 0; m < M - 7; m++) {

				boolean first_B = true;
				boolean first_W = false;
				int count_B = 0;
				int count_W = 0;

				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						if (map[n+x][m+y] != first_B) {
							count_B++;
						}
						if (map[n+x][m+y] != first_W) {
							count_W++;
						}
						first_B = !first_B;
						first_W = !first_W;
					}
					first_B = !first_B;
					first_W = !first_W;
				}
				result = Math.min(result, Math.min(count_W, count_B));
			}
		}

		System.out.print(result);
		br.close();
	}

}
