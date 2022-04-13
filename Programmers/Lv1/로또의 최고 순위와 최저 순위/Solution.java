import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int count_zero = 0;
        int count_match = 0;
        
        for(int l : lottos) {
            if(l == 0) {
                count_zero++;
                continue;
            }
            for(int w : win_nums) {
                if(l == w) {
                    count_match++;
                    break;
                }
            }
        }
        
        answer[0] = count_zero + count_match < 2 ? 6 : 7 - (count_zero + count_match);
        answer[1] = count_match < 2 ? 6 : 7 - count_match;
        
        return answer;
    }
}