import java.io.IOException;
import java.util.*;

class Solution {

	static int N, K;
	static StringTokenizer st;
	static List<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<String>();

		for (int n = 0; n < N; n++) {
			list.add(br.readLine());
		}
		Collections.sort(list, Comparator.comparing(String::length).thenComparing(String::toString));
		System.out.println(list.get(K));
	}
}
