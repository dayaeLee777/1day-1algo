import java.util.*;

class Solution {
    public int[] solution(int N, int[] A) {
        int max = 0;
        int result[] = new int[N];

        for(int a = 0; a < A.length; a++) {
            if(A[a] <= N) {
                result[A[a] - 1]++;
                if(max < A[a]) max = result[A[a] - 1];
            } else {
                for(int i = 0; i < N; i++) {
                    result[i] = max;
                }
            }
        }
        return result;
    }
}