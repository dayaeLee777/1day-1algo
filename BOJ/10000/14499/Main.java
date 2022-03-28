import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.Attributes.Name;

public class Main {

	static int N, M, x, y, k, map[][], dice[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[6]; // 0:바닥 1:서 2:남 3:위 4:동 5:북
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < k; m++) {
			int d = Integer.parseInt(st.nextToken());
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			x += dir[d][0];
			y += dir[d][1];
			move(x, y, d);
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static void move(int x, int y, int dir) {

		int tmp = dice[0];

		switch (dir) {
		case 1: // 동
			dice[0] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[1];
			break;
		case 2: // 서
			dice[0] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[4];
			dice[4] = tmp;
			break;
		case 3: // 북
			dice[0] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[2];
			dice[2] = tmp;
			break;
		case 4: // 남
			dice[0] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[5];
			dice[5] = tmp;
			break;
		}
		if (map[x][y] == 0) {
			map[x][y] = dice[0];
		} else {
			dice[0] = map[x][y];
			map[x][y] = 0;
		}
		sb.append(dice[3]).append("\n");
	}

}
