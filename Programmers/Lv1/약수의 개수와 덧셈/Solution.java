class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            int index = i;
            int count = 0;
            while(index > 0) {
                if((i / index) > 0 && (i % index == 0))
                    count++;
                index--;
            }
            if(count % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}