import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, lan[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new int[K];

		for (int k = 0; k < K; k++) {
			lan[k] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(lan);
		long min = 0L, max = lan[K - 1] + 1L, mid = 0L, result;

		while (min < max) {
			result = 0L;
			mid = (min + max) / 2L;

			for (int i = 0; i < K; i++) {
				result += lan[i] / mid;
			}
			if (result < N) {
				max = mid;
			} else {
				min = mid + 1L;
			}
		}
		System.out.println(min-1);
		br.close();
	}
}
