class Solution {
	public static int solution(int n, int k) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		// k진수로 변환
		while (n >= k) {
			sb.insert(0, n % k);
			n /= k;
		}
		sb.insert(0, n);
		// 변환된 값
		String change = sb.toString();
		long tmp = 0L; // 변환된 수 안의 P
		for (int i = 0; i < change.length(); i++) {
			// 0을 만나면 P가 소수인지 확인
			// 소수이면 answer에 1을 더해주고 P는 0으로 초기화
			if (change.charAt(i) == '0') {
				if (tmp != 0L && is_prime(tmp)) {
					answer++;
				}
				tmp = 0L;
				// 0이 아니면 P에 값을 더함
			} else {
				tmp = tmp * 10 + change.charAt(i) - '0';
			}
		}
		// for문을 돌고 난 후에는 '0P'가 존재할 수 있기 때문에 확인 필요
		if (tmp % 10 != 0L && is_prime(tmp))
			answer++;
		return answer;
	}

	// 소수 구하기
	private static boolean is_prime(long num) {
		if (num == 1)
			return false;
		// 루트로 소수 구하기
		int max = (int) Math.sqrt(num);
		for (int i = 2; i <= max; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}