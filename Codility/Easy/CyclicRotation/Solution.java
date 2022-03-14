class Solution {
    public int[] solution(int[] A, int K) {
        int[] result = new int[A.length];

        for(int a=0; a < A.length;a++){
            result[(a + K) % A.length] = A[a];
        }
        return result;
    }
}