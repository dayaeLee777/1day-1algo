import java.util.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();

        for(int a : A) {
            set.add(a);
        }

        for(int i = 0; i < A.length; i++){
            if(!set.contains(i + 1))
                return 0;
        }
        return 1;
    }
}