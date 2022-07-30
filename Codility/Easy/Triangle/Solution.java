import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for(int i = 0; i < A.length - 2; i++) {
            long P = A[i];
            long Q = A[i + 1];
            long R = A[i + 2];

            if((P + Q) > R && (Q + R) > P && (R + P) > Q)
                return 1;
        }
        return 0;
    }
}