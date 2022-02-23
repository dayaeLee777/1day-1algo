import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int Cnum;
	static Point cv[];
	static boolean isVisted[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Cnum = Integer.parseInt(br.readLine());
			cv = new Point[Cnum + 2];
			isVisted = new boolean[Cnum + 2];
			for (int c = 0; c < Cnum + 2; c++) {
				st = new StringTokenizer(br.readLine());
				cv[c] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			graph = new ArrayList[Cnum+2];
			for (int i = 0; i < Cnum + 2; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < Cnum + 2; i++) {
				for (int j = i + 1; j < Cnum + 2; j++) {
					if (getDist(cv[i], cv[j]) <= 1000) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
			sb.append(walk()).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static String walk() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		isVisted[0] = true;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();

			if(tmp == Cnum+1){
				return "happy";
			}
			for (int n : graph[tmp]) {
				if (isVisted[n]) continue;
			isVisted[n] = true;
			q.offer(n);
			}
		}
		return "sad";
	}

	private static int getDist(Point p, Point p2) {
		int res = Math.abs(p2.x - p.x) + Math.abs(p2.y - p.y);
		return res;
	}

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}

