import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] array_x = new int[10];
        int[] array_y = new int[10];

        for(char x : X.toCharArray()) {
            array_x[x - '0']++;
        }

        for(char y : Y.toCharArray()) {
            array_y[y - '0']++;
        }

        for(int i = 9; i >= 0; i--) {
            int min = Math.min(array_x[i], array_y[i]);
            while(min-- > 0) {
                sb.append(i);
            }
        }

        if(sb.length() == 0)
            sb.append(-1);

        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}