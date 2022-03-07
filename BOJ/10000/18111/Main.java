import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M, B, min, max, map[][], time, lastMax;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[n][m] = tmp;
				max = Math.max(max, tmp);
				min = Math.min(min, tmp);
			}
		}
		flat();
		System.out.println(time + " " + lastMax);
	}

	public static void flat() {
		time = Integer.MAX_VALUE;

		for (int i = min; i <= max; i++) {
			int curTime = 0;
            int inventory = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diff = map[j][k] - i;

                    if(diff > 0) { 
                        curTime += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    }else if(diff < 0){ 
                        curTime += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }
            if(inventory >= 0) {
                if(curTime <= time) { 
                    time = curTime;
                    lastMax = i;
                }
            }
		}
	}
}
