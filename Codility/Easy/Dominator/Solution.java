import java.util.*;

class Solution {
    public int solution(int[] A) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = -1;
        int length = A.length / 2;

        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            
            if(map.get(A[i]) > length) {
                result = i;
                break;
            }
        }
        return result;
    }
}