import java.util.*;

class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<Character>();
        int result = 0;
        for(char c : S.toCharArray()) {
            if(!stack.isEmpty()) {
                char peek = stack.peek();
                if(peek == '(' && c == ')')
                    stack.pop();
                else if(peek == '[' && c == ']')
                    stack.pop();
                else if(peek == '{' && c == '}')
                    stack.pop();
                else
                    stack.push(c);
            } else
                stack.push(c);
        }

        if(stack.size() == 0)
            result = 1;

        return result;
    }
}