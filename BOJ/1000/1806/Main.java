import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int N, S, input[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		input = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(st.nextToken());
		}
		int res = Integer.MAX_VALUE;
		int left = 0, right = 0, sum = 0;

		while (true) {
			if (sum >= S) {
				if (res > (right - left)) {
					res = right - left;
				}
				sum -= input[left++];
			} else if (right >= N) {
				if (res == Integer.MAX_VALUE)
					res = 0;
				break;
			} else {
				sum += input[right++];
			}
		}
		System.out.println(res);
		br.close();
	}

}

