import java.util.*;

class Solution {
    public int solution(int[] A) {
        int answer = 1;
        Arrays.sort(A);
        int size = A.length;
        
        answer = Math.max(A[size - 1] * A[size - 2] * A[size - 3], A[0] * A[1] * A[size - 1]);
         
        return answer;
    }
}