import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    
    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<String, String>();
        int answer_num = 0;
        for(String s : record) {
            StringTokenizer st = new StringTokenizer(s);
            String status = st.nextToken();
            String user_id = st.nextToken();
            String nickname = "";
            if(status.equals("Enter") || status.equals("Change")){
                nickname = st.nextToken();
                map.put(user_id, nickname);
            } 
            if(status.equals("Enter") || status.equals("Leave")){
                answer_num++;
            } 
        }
        
        String[] answer = new String[answer_num];
        int index = 0;
        for(String s : record) {
            StringTokenizer st = new StringTokenizer(s);
            String status = st.nextToken();
            String user_id = st.nextToken();
            String final_nickname = map.get(user_id);
            if(status.equals("Enter")){
                answer[index++] = String.format(ENTER_FORMAT, final_nickname);
            } 
            else if(status.equals("Leave")){
                answer[index++] = String.format(LEAVE_FORMAT, final_nickname);
            }
        }
        return answer;
    }
}