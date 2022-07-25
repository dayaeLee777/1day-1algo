import java.util.*;

class Solution {
    public int[] solution(int N, int[] A) {
        int currentMax = 0;
        int lastMax = 0;
        int result[] = new int[N];

        for(int a = 0; a < A.length; a++) {
            if(A[a] > N) {
                lastMax = currentMax;
            } else{
                int counter = A[a] - 1;
                if (result[counter] < lastMax) {
                    result[counter] = lastMax + 1;
                } else {
                    result[counter]++;
                }
                if (result[counter] > currentMax) {
                    currentMax = result[counter];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (result[i] < lastMax) {
                result[i] = lastMax;
        }
    }
        
        return result;
    }
}
