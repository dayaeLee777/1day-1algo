import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = make(p);
        
        return answer;
    }
    
    private static int divide(String s) {
        int idx = 0;
        int numOfOpen = 0;
        
        while(idx < s.length()) {
            if(s.charAt(idx) == '(') numOfOpen++;
            if(s.charAt(idx + 1) == '(') numOfOpen++;
            
            idx += 2;
            
            if(numOfOpen == idx / 2) {
                break;
            }
        }
        return idx;
    }
    
    private static String make(String s) {
        if(s.length() == 0)
            return s;
        
        StringBuilder newU = new StringBuilder();
        int subStringIdx = divide(s);
        
        String u = s.substring(0, subStringIdx);
        String v = s.substring(subStringIdx);
        
        if(isRight(u)) {
            newU.append(u).append(make(v));
        } else {
            newU.append("(").append(make(v)).append(")");
            for(int i = 1; i < u.length() - 1; i++) {
                if(u.charAt(i) == '(')
                    newU.append(')');
                else
                    newU.append('(');
            }
        }
        return newU.toString();
    }
    
    private static boolean isRight(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                stack.pop();                
            }
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}