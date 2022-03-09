import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Person member[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		member = new Person[N];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			member[n] = new Person(age, name);
		}
		Arrays.sort(member);
		for(Person p : member) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static class Person implements Comparable<Person>{
		int age;
		String name;
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.age - o.age;
		}
	}
}
