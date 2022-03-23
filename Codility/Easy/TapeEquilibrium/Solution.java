class Solution {
    public int solution(int[] A) {
        int rightSum = 0;
        int leftSum = 0;
        int answer = Integer.MAX_VALUE;

        for(int a : A)
            rightSum += a;

        for(int p = 0; p < A.length - 1; p++){
            leftSum += A[p];
            rightSum -= A[p];
            int diff = Math.abs((leftSum-rightSum));
            if(diff < answer)
                answer = diff;
        }

        return answer;
    }
}