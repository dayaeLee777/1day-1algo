class Solution {
	public static int solution(String s) {
		String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for (int n = 0; n < 10; n++) {
			s = s.replaceAll(number[n], Integer.toString(n));
		}

		int answer = Integer.parseInt(s);
		return answer;
	}
}