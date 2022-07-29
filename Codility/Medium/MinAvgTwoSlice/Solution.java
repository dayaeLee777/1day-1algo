import java.util.*;

class Solution {
    public int solution(int[] A) {
        int minIndex = -1;
        double minAverage = Integer.MAX_VALUE;
        double averageOfPtoQ = 0d;
        int sum = 0;

        for(int p = 0; p < A.length - 1; p++) {
            sum = A[p];
            for(int q = p + 1; q < A.length; q++) {
                sum += A[q];
                averageOfPtoQ = (double) sum / (q - p + 1);
                if(minAverage > averageOfPtoQ){
                    minAverage = averageOfPtoQ;
                    minIndex = p;
                }
            }
        }
        return minIndex;
    }
}