import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int order_index = 0;
        Stack<Integer> sub = new Stack<Integer>();
        Queue<Integer> main = new LinkedList<Integer>();

        for(int o = 0; o < order.length; o++){
            main.offer(o + 1);
        }

        while(order_index < order.length) {
            while(true) {
                if(!main.isEmpty() && main.peek() == order[order_index]){
                    main.poll();
                    answer++;
                    break;
                }
                else if(!main.isEmpty() && main.peek() < order[order_index]){
                    sub.push(main.poll());
                } else {
                    if(!sub.isEmpty() && sub.peek() == order[order_index]) {
                        sub.pop();
                        answer++;
                        break;
                    } else {
                        return answer;
                    }
                }
            }
            order_index++;
        }

        return answer;
    }
}