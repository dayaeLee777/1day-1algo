class Solution {
    public String solution(int n) {
        String answer = "";
		int[] country = { 0, 1, 2, 4 };

		while (n > 0) {
			if(n % 3 == 0) {
				answer = Integer.toString(country[3]).concat(answer);
				n = n / 3 - 1;
			} else {
				answer = Integer.toString(country[n % 3]).concat(answer);
				n /= 3;
			}
		}
		return answer;
    }
}