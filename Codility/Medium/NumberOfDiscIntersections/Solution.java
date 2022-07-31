import java.util.*;

class Solution {
    public int solution(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length - 1; i++) {
            long discI = A[i]; 
            for(int j = i + 1; j < A.length; j++) {
                long discJ = A[j];
                if((i - discI <= j - discJ) && (i + discI >= j - discJ)){
                        result++;
                        continue;
                    } 
                else if((i - discI >= j - discJ) && (i - discI <= j + discJ)){
                        result++;
                    }
            }
        }
        if(result > 10000000)
            result = -1;
        return result;
    }
}