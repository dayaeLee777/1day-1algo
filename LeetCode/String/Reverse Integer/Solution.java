class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while(x > 0 || x < 0) {
            if(result > (Integer.MAX_VALUE - 1) / 10 || result < Integer.MIN_VALUE / 10)
                return 0;
            
            result *= 10;
            result += x % 10;
                
            x /= 10;
        }
        return result;
    }
}