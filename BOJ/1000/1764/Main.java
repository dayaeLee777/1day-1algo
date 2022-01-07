import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<String> res = new ArrayList<String>();

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < N + M; i++) {
			String cur = br.readLine();
			if (!set.add(cur))
				res.add(cur);

		}
		res.sort(Comparator.naturalOrder());
		sb.append(res.size()).append("\n");
		for(String s : res)
			sb.append(s).append("\n");
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
