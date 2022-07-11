class Solution {
    public int[] plusOne(int[] digits) {
        
        int index = digits.length - 1;
        
        while(index >= 0) {
            if(digits[index] == 9) {
                digits[index--] = 0;
            } 
            else{
                digits[index]++;
                break;
            }
        }
        
        int[] new_digits;
        if(digits[0] == 0) {
            new_digits = new int[digits.length + 1];
            new_digits[0] = 1;
            for(int i = 0; i < digits.length; i++) {
                new_digits[i+1] = digits[i];
            }
            return new_digits;
        } else
            return digits;
    }
}