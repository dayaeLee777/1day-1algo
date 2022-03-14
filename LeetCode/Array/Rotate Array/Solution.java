class Solution {
    public void rotate(int[] nums, int k) {
        int result[] = new int[nums.length];
        for(int n = 0; n < nums.length; n++) {
            result[(n+k)%nums.length] = nums[n];
        }
        for(int n = 0; n < nums.length; n++) {
            nums[n] = result[n];
        } 
    }
}