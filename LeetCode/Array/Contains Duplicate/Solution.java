// 정렬 후 배열 요소 비교
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int n = 0; n < nums.length - 1; n++){
            if(nums[n] == nums[n+1])
                return true;
        }
        return false;
    }
}


// Set 적용
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<Integer>();
        for(int n : nums){
            if(distinct.contains(n))
                return true;
            else
                distinct.add(n);
        }
        return false;
    }
}