import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, s.length()).concat(s.substring(0, i));
            if(isRight(temp)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isRight(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                else if((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']') || (stack.peek() == '{' && c == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
                    
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}