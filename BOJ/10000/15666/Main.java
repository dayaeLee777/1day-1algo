import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, array[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();;
	static Set<Integer> set;
	static List<Integer> setList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[M];
		set = new HashSet<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int temp = Integer.parseInt(st.nextToken());
			set.add(temp);
		}

		setList = new ArrayList<Integer>(set);
		Collections.sort(setList);

		makeArray(0, 0);
		System.out.println(sb);
		br.close();
	}

	private static void makeArray(int count, int idx) {
		if (count == M) {
			for (int a : array) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < setList.size(); i++) {
			array[count] = setList.get(i);
			makeArray(count + 1, i);
		}
	}

}
