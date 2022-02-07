import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	static StringTokenizer st;
	static boolean bro[] = new boolean[10];
	static String ns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ns = br.readLine();
		N = Integer.parseInt(ns);
		M = Integer.parseInt(br.readLine());

		result = Math.abs(N - 100);

		if (N == 100)
			result = 0;

		else if (M == 0)
			result = result > ns.length() ? ns.length() : result;

		else {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				bro[Integer.parseInt(st.nextToken())] = true;
			}
			find(0, "");
		}
		System.out.println(result);

		br.close();
	}

	static void find(int idx, String res) {
		for (int i = 0; i < 10; i++) {
			if (!bro[i]) {
				String nRes = res + i;
				int tmp = Math.abs(N - Integer.parseInt(nRes)) + nRes.length();
				result = result < tmp ? result : tmp;
				if (idx < 6)
					find(idx + 1, nRes);
			}
		}

	}
}

