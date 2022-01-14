import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		N = sc.nextInt();
		int input = 0;
		for (int n = 0; n < N; n++) {
			input = sc.nextInt();
			if (input == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else
				pq.offer(input);

		}

		System.out.println(sb);
	}
}
