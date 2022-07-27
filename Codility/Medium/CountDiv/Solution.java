import java.util.*;

class Solution {
    public int solution(int A, int B, int K) {
        int result = 0;
        int countOfB = B / K;

        int countOfA =  A / K;
        if(A % K == 0)
            countOfA--;

        result = countOfB - countOfA;
        return result;
    }
}