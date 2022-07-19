import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 1;
        int sizeOfNums = nums.length / 2;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int n : nums) {
            set.add(n);
        }
        int sizeOfSet = set.size();
        answer = Math.min(sizeOfNums, sizeOfSet);
        return answer;
    }
}