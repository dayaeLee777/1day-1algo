import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> current = new HashMap<String, Integer>();

        for(int d = 0; d < 10; d++) {
            current.compute(discount[d], (k, v) -> (v == null) ? 1 : v + 1);
        }

        int start = 0;
        int end = 10;

        while(end < discount.length) {
            int count = 0;
            for(int i = 0; i < want.length; i++) {
                if(!current.containsKey(want[i]))
                    break;
                if(current.get(want[i]) != number[i])
                    break;
                count++;
            }
            if(count == want.length){
                answer++;
            }
            current.compute(discount[start], (k, v) -> (v == 0) ? 0 : v - 1);
            current.compute(discount[end], (k, v) -> (v == null) ? 1 : v + 1);
            end++;
            start++;
        }
        int count = 0;
        for(int i = 0; i < want.length; i++) {
            if(!current.containsKey(want[i]))
                    break;
            if(current.get(want[i]) != number[i])
                break;
            count++;
        }
        if(count == want.length){
            answer++;
        }
        return answer;
    }
}