import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int l = 0; l < lost.length; l++) {
            for(int r = 0; r < reserve.length; r++) {
                if(lost[l] == reserve[r]) {
                    answer++;
                    lost[l] = -1;
                    reserve[r] = -1;
                    break;
                }
            }
        }
        
        for(int l = 0; l < lost.length; l++) {
            for(int r = 0; r < reserve.length; r++) {
                if(lost[l] == reserve[r] + 1 || lost[l] == reserve[r] - 1) {
                    answer++;
                    reserve[r] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}