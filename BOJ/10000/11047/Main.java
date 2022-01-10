import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int N, K, res, input[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N];
		res = 0;
		
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(br.readLine());
		}
		int n = N-1;
		while(n>=0 && K != 0) {
			if(K>=input[n]) {
				int divide = K/input[n];
				res += divide;
				K -= divide * input[n];
			}
			n--;
		}
		
		System.out.println(res);
		br.close();
	}

}
