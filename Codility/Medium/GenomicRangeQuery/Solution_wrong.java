import java.util.*;

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        for(int i = 0; i < P.length; i++) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int start = P[i];
            int end = Q[i];

            for(int j = start; j <= end; j++) {
                char currChar = S.charAt(j);
                map.compute(currChar, (k, v) -> (v == null) ? 1 : v+1);
            }
            Character minChar =  Collections.min(map.keySet());
            result[i] = getDNA(minChar);
        }

        return result;
    }

    private static int getDNA(char c) {
        int result = 0;
        if(c == 'A')
            result = 1;
        else if(c == 'C')
            result = 2;
        else if(c == 'G')
            result = 3;
        else if(c == 'T')
            result = 4;
            
        return result;
    }
}
