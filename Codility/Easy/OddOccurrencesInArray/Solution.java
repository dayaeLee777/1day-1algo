class Solution {
    public int solution(int[] A) {
        int result = 0;
        for(int a = 0; a < A.length; a++){
            result = result ^ A[a];
        }
        return result;
    }
}
