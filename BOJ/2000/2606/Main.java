import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int C, N, res, map[][];
	static boolean computer[];
	static StringTokenizer st;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		res = 0;
		q = new LinkedList<Integer>();
		computer = new boolean[C + 1];
		map = new int[C+1][C+1];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		findVirus(1);
		for (int c = 2; c <= C; c++) {
			if (computer[c])
				res++;
		}
		System.out.println(res);
	}
	
	private static void findVirus(int idx) {
		q.offer(idx);
		computer[idx] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1; i<=C;i++)
			if (!computer[i] && map[cur][i]==1) {
					computer[i] = true;
					q.offer(i);
			}
		}
	}

}

