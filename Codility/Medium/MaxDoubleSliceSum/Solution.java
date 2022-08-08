import java.util.*;

class Solution {
    public int solution(int[] A) {
        int result = 0;
        int sumX[] = new int[A.length];
        int sumY[] = new int[A.length];

        for(int i = 1; i < A.length - 1; i++) {
            sumX[i] = Math.max(0, sumX[i - 1] + A[i]);
        }
        
        for(int i = A.length - 2; i > 0; i--) {
            sumY[i] = Math.max(0, sumY[i + 1] + A[i]);
        }
        
        for(int i = 1; i < A.length - 1; i++) {
            result = Math.max(result, sumX[i - 1] + sumY[i + 1]);
        }

        return result;
    }
}