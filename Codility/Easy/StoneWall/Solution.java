import java.util.*;

class Solution {
    public int solution(int[] H) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int h : H) {
            if(stack.isEmpty()){
                stack.push(h);
            } else {
                while(!stack.isEmpty() && stack.peek() > h) {
                    stack.pop();
                    result++;
                }
                if(!stack.isEmpty() && stack.peek() == h)
                    continue;
                stack.push(h);
            }
        }
        return result + stack.size();
    }
}