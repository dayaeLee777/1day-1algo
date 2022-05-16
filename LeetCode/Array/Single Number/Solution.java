class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        int count = 0;
        for(int n = 1; n < nums.length; n++){
            if(pre == nums[n]) {
                count++;
            } else {
                if(count == 0)
                    return pre;
                count = 0;
            }
            pre = nums[n];
        }
        return pre;
    }
}