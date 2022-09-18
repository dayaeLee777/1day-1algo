class Solution {
    public int[] solution(int n, long left, long right) {
        int diff = (int) (right - left);
        int[] answer = new int[diff + 1];
        
        for(long i = left; i <= right; i++) {
            int idx = Math.max((int) (i % n), (int) (i / n)); 
            answer[(int)(i - left)] = idx + 1;
        }
        
        return answer;
    }
}