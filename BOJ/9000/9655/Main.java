import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, dp[];
	static String result;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[1001];
		// 상근SK 1, 찬영CY 2

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 2;

		if (N <= 4) {
			if (dp[N] == 1)
				result = "SK";
			else
				result = "CY";
		}

		for (int i = 5; i <= N; i++) {
			dp[i] = dp[i - 4];
		}

		if (dp[N] == 1)
			result = "SK";
		else
			result = "CY";

		System.out.println(result);
		br.close();
	}

}