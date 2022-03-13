class Solution {
    public int removeDuplicates(int[] nums) {
//         int result = 0;
//         int index = 1;
//         int preNum = nums[0];
        
//         while(index < nums.length){
//             if(preNum != nums[index]){
//                 result++;
//                 preNum = nums[index];
//             } else {
//                 nums[index] = Integer.MAX_VALUE;
//             }
//             index++;
//         }
        
//         Arrays.sort(nums);
//         return result+1;
        
        int index = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[index] != nums[j]){
                index++;
                nums[index] = nums[j];
            }
        }
        return index + 1;
    }
}