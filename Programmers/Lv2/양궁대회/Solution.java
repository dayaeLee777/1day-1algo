class Solution {
    
    static int lion[], max;
    static int answer[] = {-1};
    
    public int[] solution(int n, int[] info) {
        lion = new int[11];
        max = Integer.MIN_VALUE;
        
        find(info, 0, n, 0);
        
        return answer;
    }
    
    private void find(int[] info, int count, int n, int idx) {
        if(count >= n) {
            score(info);
            return;
        }
        
        for(int i = idx; i <= 10; i++) {
            lion[i]++;
            find(info, count + 1, n, i);
            lion[i]--;
        }
    }
    
    private void score(int[] info) {
        int appeach_score = 0;
        int lion_score = 0;
        
        for(int i = 0; i <= 10; i ++) {
            if(lion[i] == 0 && info[i] == 0)
                continue;
            if(lion[i] > info[i])
                lion_score += (10 - i);
            else
                appeach_score += (10 - i);
        }
        
        if(lion_score > appeach_score) {
            if(lion_score - appeach_score > max) {
                max = lion_score - appeach_score;
                
                answer = new int[11];
                for(int i = 0; i <= 10; i ++) {
                    answer[i] = lion[i];
                }
            } else if(lion_score - appeach_score == max) {
                for(int i = 10; i >= 0; i--) {
                    if(answer[i] > lion[i]) {
                        break;
                    } else if(answer[i] < lion[i]) {
                        answer = new int[11];
                        for(int j = 0; j <= 10; j ++) {
                            answer[j] = lion[j];
                        }
                        break;
                    }
                }
            }
        }
    }
}