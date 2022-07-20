import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int idx = -1;
        for(int a = 0; a < A.length; a++) {
            
            if(A[a] <= X)
                set.add(A[a]);

            if(set.size() == X){
                idx = a;
                break;
            }
        }
        return idx;
    }
}