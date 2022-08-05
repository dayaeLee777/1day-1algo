import java.util.*;

class Solution {
    public int solution(int[] A) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            if(min < A[i]) {
                profit = Math.max(profit, A[i] - min);
            }
        }
        return profit;
    }
}