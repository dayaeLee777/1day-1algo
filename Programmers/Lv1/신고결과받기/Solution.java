import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main2 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashMap<String, Set<String>> reporterArr = new HashMap<String, Set<String>>();
		HashMap<String, Integer> singoArr = new HashMap<String, Integer>();

		// 초기화
		for (String id : id_list) {
			singoArr.put(id, 0);
			reporterArr.put(id, new HashSet<String>());
		}
		// 신고된 사람들
		for (String cur : report) {
			StringTokenizer st = new StringTokenizer(cur, " ");
			String reporter = st.nextToken();
			String singo = st.nextToken();
			if (reporterArr.get(reporter).add(singo)) {
				singoArr.put(singo, singoArr.get(singo) + 1);
			}
		}

		// 신고한 사람
		for (String cur : report) {
			StringTokenizer st = new StringTokenizer(cur, " ");
			String reporter = st.nextToken();
			String singo = st.nextToken();
			// 본인이 신고한 사람의 신고당한 횟수가 K이상일 경우이만 남겨
			if (singoArr.get(singo) < k)
				reporterArr.get(reporter).remove(singo);
		}

		for (int i = 0; i < id_list.length; i++) {
			answer[i] = reporterArr.get(id_list[i]).size();
		}

		return answer;
	}
}
