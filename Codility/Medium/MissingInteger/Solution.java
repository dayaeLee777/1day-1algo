import java.util.*;

class Solution {
    public int solution(int[] A) {
        int result = 1;
        int index = 0;
        Arrays.sort(A);

        while(index < A.length) {
            if(result == A[index]){
                result++;
            }
            index++;
        }

        return result;
    }
}