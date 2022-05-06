class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        StringBuilder sb;
        for(int i = length / 2; i >= 1; i--) {
            String pre = s.substring(0,  i);
            sb = new StringBuilder();
            int count = 1;
            for(int j = i; j <= length; j += i) {
                String cur;
                if(j + i > length)
                    cur = s.substring(j, length);
                else
                    cur = s.substring(j, j + i);
                if(pre.equals(cur)) {
                    count++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(pre);
                    pre = cur;
                }
            }
            sb.append(pre);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}