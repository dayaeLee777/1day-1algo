import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, S, X, Y, map[][];
	static StringTokenizer st;
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static PriorityQueue<Virus> pq = new PriorityQueue<Virus>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if (map[n][m] != 0)
					pq.add(new Virus(n, m, map[n][m], 0));
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		virus();

		System.out.println(map[X - 1][Y - 1]);
	}

	public static void virus() {

		while (!pq.isEmpty()) {
			Virus cur = pq.poll();
			
			if(map[X-1][Y-1] != 0)
				return;
			
			if(cur.time == S)
				return;
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dir[d][0];
				int ny = cur.y + dir[d][1];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
					map[nx][ny] = cur.num;
					pq.offer(new Virus(nx, ny, cur.num, cur.time + 1));
				}
			}
		}
	}

	private static class Virus implements Comparable<Virus> {

		int x;
		int y;
		int num;
		int time;

		public Virus() {
			super();
		}

		public Virus(int x, int y, int num, int time) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getNum() {
			return num;
		}

		public int getTime() {
			return time;
		}

		@Override
		public int compareTo(Virus o) {
			return Comparator.comparing(Virus::getTime)
					.thenComparing(Virus::getNum)
					.compare(this, o);
		}
	}
}
