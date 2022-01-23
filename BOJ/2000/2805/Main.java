import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long mid, min, max;
	static int[] tree;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int n = 0; n < N; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);

		min = 0;
		max = tree[N - 1];

		while (min < max) {
			mid = (min + max) / 2;
			long sum = 0;
			for (int h : tree) {
				if (h - mid > 0)
					sum += (h - mid);
			}
			if (sum < M)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min-1);
		br.close();
	}
}
