class Solution {
    public int solution(int[] A) {
        int answer = -1;
        boolean[] isExisted = new boolean[A.length+2];

        for(int a : A)
            isExisted[a] = true;

         for(int i = 1; i < isExisted.length; i++){
             if(!isExisted[i])
                answer = i;
         }   
        return answer;
    }
}