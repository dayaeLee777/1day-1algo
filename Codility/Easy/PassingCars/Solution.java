import java.util.*;

class Solution {
    public int solution(int[] A) {
        int sumOfWest = 0;
        int result = 0;

        for(int a : A) {
            sumOfWest += a;
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0){
                result += sumOfWest;
            } else {
                sumOfWest--;
            }
            if(result > 1000000000)
                return -1;
        }
        return result;
    }
}