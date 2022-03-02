import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, K, array[], idx;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList<Integer>();
		idx = 0;

		for (int n = 0; n < N; n++) {
			list.add(n+1);
		}

		sb.append("<");

		while (!list.isEmpty()) {
			idx = (idx + (K - 1)) % list.size();
			sb.append(list.remove(idx)).append(", ");
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb.toString());
	}
}
