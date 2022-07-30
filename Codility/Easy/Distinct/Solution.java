import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int a : A) 
            set.add(a);

        return set.size();
    }
}