import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		dp[1] =0;

		for (int d = 2; d <= N; d++) {
			dp[d] = dp[d - 1] + 1;
			
			if (d % 2 == 0)
				dp[d] = Math.min(dp[d], dp[d / 2] + 1);
			
			if (d % 3 == 0)
				dp[d] = Math.min(dp[d], dp[d / 3] + 1);

		}
		System.out.println(dp[N]);
		br.close();
	}
}
