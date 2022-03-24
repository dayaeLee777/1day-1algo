class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            map.put(sc, map.getOrDefault(sc, 0) + 1);
            map.put(tc, map.getOrDefault(tc, 0) - 1);
        }
        
        for(int v : map.values()){
            if(v != 0)
                return false;
        }
        
        return true;
    }
}