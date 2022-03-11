class Solution {
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        int leftMove = 0;
        int rightMove = 0;
        
        for(int n : numbers){
            if(n % 3 == 1) {
                sb.append("L");
                left = n;
            }
            else if(n % 3 == 0 && n != 0) {
                sb.append("R");
                right = n;
            }
            else {
                if(n == 0) n += 11;
                
                if(left % 3 == 2)
                    leftMove = Math.abs(left - n) / 3;
                else
                    leftMove = Math.abs((left+1) - n) / 3 + 1;
                
                if(right % 3 == 2)
                    rightMove = Math.abs(right - n) / 3;
                else
                    rightMove = Math.abs((right-1) - n) / 3 + 1;
                
                if(leftMove == rightMove) {
                    if(hand.equals("left")) {
                        sb.append("L");
                        left = n;
                    }
                    else{
                        sb.append("R");
                        right = n;
                    }
                }
                else if(leftMove < rightMove) {
                    sb.append("L");
                    left = n;
                } else {
                    sb.append("R");
                    right = n;
                }
            }
        }
        return sb.toString();
    }
}