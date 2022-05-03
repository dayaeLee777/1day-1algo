import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
move:   for(int m : moves) {
            for(int r = 0; r < board.length; r++) {
                if(board[r][m-1] == 0) continue;
                if(!stack.empty() && stack.peek() == board[r][m-1]) {
                    stack.pop();
                    answer += 2;
                }else {
                    stack.push(board[r][m-1]);
                }
                board[r][m-1] = 0;
                continue move;
            }
        }
        return answer;
    }
}