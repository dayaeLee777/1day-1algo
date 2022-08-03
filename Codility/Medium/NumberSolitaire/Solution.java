import java.util.*;

class Solution {
    public int solution(int[] A) {
        int dp[] = new int [A.length];
        dp[0] = A[0];
        for(int n = 1; n < A.length; n++) {
            int pre = dp[n-1] + A[n];
            for(int d = 2; d <= 6; d++) {
                if(n - d < 0)
                    continue;
                pre = Math.max(pre, dp[n-d] + A[n]);
            }
            dp[n] = pre;
        }
        return dp[A.length-1];
    }
}