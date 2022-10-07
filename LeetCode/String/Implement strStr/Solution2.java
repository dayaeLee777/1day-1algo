class Solution {
    public int strStr(String haystack, String needle) {
        int lh = haystack.length();
        int ln = needle.length();
        
        if(lh < ln) 
            return -1;
        if(ln == 0)
            return 0;
        
        int diff = lh - ln;
        for(int i = 0; i <= diff; i++) {
            if(haystack.substring(i, i + ln).equals(needle))
                return i;
        }
        return -1;
    }
}