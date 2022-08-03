import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M, dp[][];
	static String result;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		dp = new int[31][31];

		for (int i = 0; i <= 30; i++) {
			dp[i][0] = 1;
			for (int j = 0; j <= 30; j++) {
				if (i == j)
					dp[i][j] = 1;
			}
		}

		for (int i = 1; i <= 30; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			sb.append(dp[M][N]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
