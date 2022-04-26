import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, belt[], stage, count;
	static StringTokenizer st;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new int[2 * N];
		robot = new boolean[N];
		stage = 0;

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N * 2; n++) {
			belt[n] = Integer.parseInt(st.nextToken());
		}
		move();
		System.out.println(stage);
	}

	private static void move() {
		while (true) {
			stage++;
			moveBelt();
			moveRobot();

			if (belt[0] != 0) {
				belt[0]--;
				robot[0] = true;
			}

			int zeroCount = 0;
			for (int n = 0; n < N * 2; n++) {
				if (belt[n] == 0)
					zeroCount++;
			}
			if (zeroCount >= K)
				return;
		}
	}

	private static void moveRobot() {
		robot[N - 1] = false;
		for (int i = N - 1; i > 0; i--) {
			if (robot[i - 1] && !robot[i] && belt[i] >= 1) {
				robot[i] = true;
				robot[i - 1] = false;
				belt[i]--;
			}
		}
//		for (int n = N - 1; n >= 0; n--) {
//			if (robot[n]) {
//				int idx = n;
//				while (idx < N - 1) {
//					if (idx == N - 1) {
//						robot[idx] = false;
//						break;
//					}
//					if (robot[idx + 1] || belt[idx + 1] < 1)
//						break;
//					robot[idx + 1] = true;
//					robot[idx] = false;
//					belt[idx + 1]--;
//					idx++;
//				}
//			}
//		}
	}

	private static void moveBelt() {
		int temp = belt[2 * N - 1];
		for (int n = 2 * N - 2; n >= 0; n--) {
			belt[n + 1] = belt[n];
		}
		belt[0] = temp;

		for (int n = N - 2; n >= 0; n--) {
			robot[n + 1] = robot[n];
		}
		robot[0] = false;
	}
}
