class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * (long) h;
        
        if(w == h) {
            return answer - w;
        }
        
        int max = Math.max(w, h);
        int min = Math.min(w, h);
        
        int GCD = getGCD(max, min);
        max /= GCD;
        min /= GCD;
        
        answer -= (max + min - 1) * GCD;
        
        return answer;
    }
    
    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}