import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> list = new ArrayList<String>();
        
        for(String cityOrigin : cities) {
            String city = cityOrigin.toLowerCase();
            if(list.contains(city)) {
                answer += 1;
            } else {
                answer += 5;
            }
            
            if(cacheSize == 0)
                continue;
            
            if(list.contains(city)) {
                list.remove(city);
            }
            else if(list.size() == cacheSize) {
                list.remove(0);
            }
            list.add(city);
        }
        return answer;
    }
}
    