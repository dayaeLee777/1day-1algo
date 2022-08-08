import java.util.*;

class Solution {
    public int solution(int[] A) {
        int sum[] = new int[A.length];
        sum[0] = A[0];
        int max = sum[0];
        for(int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
            max = Math.max(max, sum[i]);
        }

        for(int i = 1; i < A.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                max = Math.max(max, sum[i] - sum[j]);
            }
        }

        return max;
    }
}