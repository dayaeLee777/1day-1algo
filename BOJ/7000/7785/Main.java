import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		HashMap<String, Boolean> officer = new HashMap<String, Boolean>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			String people = st.nextToken();
			boolean isOffice = st.nextToken().equals("enter") ? true : false;
			if(officer.containsKey(people)) {
				officer.replace(people, isOffice);
			}else {
				officer.put(people, isOffice);
			}
		}
		Object[] mapkey = officer.keySet().toArray();
		Arrays.sort(mapkey, Collections.reverseOrder());
		
		for(Object s : mapkey) {
			if(officer.get(s))
				sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}
}
