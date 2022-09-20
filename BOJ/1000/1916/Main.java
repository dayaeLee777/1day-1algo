import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, start, end, distance[];
	static List<Edge>[] edgelist;
	static StringTokenizer st;
	static boolean isVisited[];
	static int INFINITY = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edgelist = new ArrayList[N + 1];
		distance = new int[N + 1];
		isVisited = new boolean[N + 1];

		for (int n = 1; n <= N; n++) {
			edgelist[n] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgelist[s].add(new Edge(e, w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		Dijkstra(start);

		System.out.println(distance[end]);
	}

	private static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (isVisited[cur.end])
				continue;

			isVisited[cur.end] = true;

			for (Edge e : edgelist[cur.end]) {
				if (distance[cur.end] + e.weight < distance[e.end]) {
					distance[e.end] = distance[cur.end] + e.weight;
					pq.offer(new Edge(e.end, distance[e.end]));
				}
			}
		}
	}

	private static class Edge implements Comparable<Edge> {
		int end;
		int weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}