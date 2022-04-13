class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String  answer = new_id.toLowerCase();
        for(char c : answer.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.' )
                sb.append(c);
        }
        answer = sb.toString();
        while(answer.contains(".."))
            answer = answer.replace("..", ".");
        
        if(!answer.isEmpty() && answer.charAt(0) == '.')
            answer = answer.substring(1);
        if(!answer.isEmpty() && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);
        
        if(answer.isEmpty())
            answer = "a";
        
        if(answer.length() >= 16)
            answer = answer.substring(0, 15);
        
        if(!answer.isEmpty() && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);
        
        while(answer.length() <= 2){
             answer = answer.concat(answer.substring(answer.length()-1));
        }
        
        return answer;
    }
}