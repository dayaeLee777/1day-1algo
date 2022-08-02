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
                    stack.pop();import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int result = 0;
        int sizeOfFish = 0;
        Stack<Integer> fish = new Stack<Integer>();
        
        for(int i = 0; i < A.length; i++) {
            if(B[i] == 1){
                fish.push(A[i]);
            }
            else {
                while(!fish.isEmpty()) {
                    sizeOfFish = fish.peek();
                    if(sizeOfFish < A[i]) {
                        fish.pop();
                    } else {
                        sizeOfFish = fish.peek();
                        break;
                    }
                }
                if(fish.isEmpty()) {
                    result++;
                }
            }
        }

        result += fish.size();

        return result;
    }
}
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