import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int n=1;n<=N ;n++) {
			arr.add(n);
		}
		int cnt=0;
		sb.append("<");
		while(!arr.isEmpty()) {
			cnt = (cnt+K-1) % arr.size();
			sb.append(arr.get(cnt));
			arr.remove(cnt);
			sb.append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}

}

