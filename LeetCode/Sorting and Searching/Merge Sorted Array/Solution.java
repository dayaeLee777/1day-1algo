class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0){
            nums1[n+m-1] = nums1[m-1] > nums2[n-1] ? nums1[(m--) - 1] : nums2[(n--) - 1];
        }
        while(n > 0) {
            nums1[n - 1] = nums2[(n--) - 1];
        }
    }
}