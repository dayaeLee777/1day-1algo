import java.util.*;

class Solution {
    public int solution(int A, int B, int K) {
        int result = 0;

        for(int i = A; i <= B; i++) {
            if(i % K == 0)
                result++;
        }

        return result;
    }
}