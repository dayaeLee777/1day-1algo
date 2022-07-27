import java.util.*;

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[][] array = new int[S.length()][5];
        int[] result = new int[P.length];

        for(int s = 0; s < S.length(); s++) {
            int index = getDNA(S.charAt(s));
            array[s][index] = 1;
        }

        for(int s = 1; s < S.length(); s++) {
            for(int c = 1; c < 5; c++) {
                array[s][c] += array[s - 1][c];
            }
        }

        for(int i = 0; i < P.length; i++) {
            for(int c = 1; c < 5; c++) {
                int start = P[i] == 0 ? 0 : array[P[i] - 1][c];
                int end = array[Q[i]][c];
                int temp = end - start;
                if(temp > 0) {
                    result[i] = c;
                    break;
                }
            }
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