class Solution {
    public String solution(int n) {
        		String answer = "";
		int[] country = { 4, 1, 2 };

		while (n > 0) {
				answer = Integer.toString(country[n % 3]).concat(answer);
				n = (n-1) / 3;
		}
		return answer;
    }
}