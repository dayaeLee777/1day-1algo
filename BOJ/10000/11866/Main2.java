import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, array[], idx;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			q.offer(n + 1);
		}

		sb.append("<");
		while (!q.isEmpty()) {
			for (int k = 0; k < K - 1; k++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb.toString());
	}
}
