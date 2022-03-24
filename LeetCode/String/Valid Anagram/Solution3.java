class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        int[] array = new int[26];
        
        for(int i=0; i < s.length(); i++){
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < 26; i++){
            if(array[i] != 0)
                return false;
        }
        
        return true;
    }
}