import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], result;
	static StringTokenizer st;
	static int dir[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static Queue<Fish> q;
	static boolean[][] isVisited;
	static Fish babyShark;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		q = new LinkedList<Fish>();

		result = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 9) {
					q.offer(new Fish(r, c, 0));
					map[r][c] = 0;
				}
			}
		}
		eatFish();
		System.out.println(result);
	}

	private static void eatFish() {
		int size = 2;
		int countFish = 0;

		while (true) {
			isVisited = new boolean[N][N];
			PriorityQueue<Fish> fish = new PriorityQueue<Fish>();

			while (!q.isEmpty()) {
				Fish shark = q.poll();
				int sharkR = shark.r;
				int sharkC = shark.c;

				for (int d = 0; d < 4; d++) {
					int nr = sharkR + dir[d][0];
					int nc = sharkC + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc] && size >= map[nr][nc]) {
						q.offer(new Fish(nr, nc, shark.dist + 1));
						isVisited[nr][nc] = true;
						if (map[nr][nc] > 0 && size > map[nr][nc])
							fish.offer(new Fish(nr, nc, shark.dist + 1));
					}
				}
			}
			if(fish.isEmpty())
				return;
			Fish caughtFish = fish.poll();
			result += caughtFish.dist;
			countFish++;
			map[caughtFish.r][caughtFish.c] = 0;
			if(size == countFish) {
				size++;
				countFish = 0;
			}
			
			q.offer(new Fish(caughtFish.r, caughtFish.c, 0));
		}
	}

	private static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int dist;

		public Fish() {
			super();
		}

		public Fish(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (o.dist == this.dist) {
				if (o.r == this.r)
					return this.c - o.c;
				return this.r - o.r;
			}
			return this.dist - o.dist;
		}
	}
}
