class Solution {
    public int solution(int N) {
        int maxZeroCnt = Integer.MIN_VALUE;
        int zero = 0;

        StringBuilder sb = new StringBuilder();

        while(N > 1) {
            sb.append(N % 2);
            N /= 2;
        }
        sb.append(N);
        
        String binaryString = sb.toString();
        boolean ing = false;

        for(char b : binaryString.toCharArray()){
            if(b == '0' && ing) {
                zero++;
            }
            else if(b == '1') {
                ing = true;
                maxZeroCnt = Math.max(zero, maxZeroCnt);
                zero = 0;
            }
        }
        return maxZeroCnt;
    }
}