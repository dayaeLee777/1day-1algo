import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = -1;
        int min = Integer.MAX_VALUE;

        // for(int )

        return answer;
    }

    private static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[origin.length][origin[0].length];

        for(int x = 0; x < origin.length; x++) {
            for(int y = 0; y < origin[0].length; y++) {
                copy[x][y] = origin[x][y];
            }
        }

        return copy;
    }
}