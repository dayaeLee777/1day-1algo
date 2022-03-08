import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();

		int idx = 0;
		int num = 1;

		while (num++ <= N) {
			int value = sc.nextInt();

			if (value > idx) {
				for (int i = idx + 1; i <= value; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				idx = value;
			} else if (stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb.toString());
	}
}