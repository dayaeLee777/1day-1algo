import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		dp[1] = 1;
		for (int d = 2; d <= N; d++) {
			int sqrt = (int) Math.sqrt(d);
			dp[d] = dp[d - 1] + 1;
			while (sqrt > 0) {
				dp[d] = Math.min(dp[d], dp[d - sqrt * sqrt] + 1);
				sqrt--;
			}
		}
		System.out.println(dp[N]);
		br.close();
	}
}
