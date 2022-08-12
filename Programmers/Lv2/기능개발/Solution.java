import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
		ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            q.offer(day);
        }
        
        int min = q.poll();
        int count = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(min < cur) {
                min = cur;
                answer.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        
        answer.add(count);
        int[] result = new int[answer.size()];
        for(int a = 0; a < answer.size(); a++)
            result[a] = answer.get(a);
        
        return result;
    }
}