import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for(int i = 0; i < A.length - 2; i++) {
            int P = A[i];
            int Q = A[i + 1];
            int R = A[i + 2];

            if((P + Q) > R && (Q + R) > P && (R + P) > Q)
                return 1;
        }
        return 0;
    }
}