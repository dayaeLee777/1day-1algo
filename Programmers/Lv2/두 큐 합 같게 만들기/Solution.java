import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        long sum_q1 = 0;
        for(int q = 0; q < queue1.length; q++) {
            sum_q1 += queue1[q];
            q1.offer(queue1[q]);
        }
        
        long sum_q2 = 0;
        for(int q = 0; q < queue2.length; q++) {
            sum_q2 += queue2[q];
            q2.offer(queue2[q]);
        }
        
        int count = 0;
        
        while(sum_q1 != sum_q2 && !q1.isEmpty() && !q2.isEmpty() && count < (queue1.length + queue2.length) * 2) {
            if(sum_q1 > sum_q2) {
                int temp = q1.poll();
                q2.offer(temp);
                sum_q1 -= temp;
                sum_q2 += temp;
            } else {
                int temp = q2.poll();
                q1.offer(temp);
                sum_q1 += temp;
                sum_q2 -= temp;
            }
            count++;
        }
        
        if(sum_q1 == sum_q2)
            answer = count;
        
        return answer;
    }
}