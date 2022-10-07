class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuilder result = new StringBuilder();
        
go:     while(true) {
    
            if(index >= strs[0].length())
                break go;
            char prefix = strs[0].charAt(index);
            
            for(int s = 1; s < strs.length; s++) {
                if(index >= strs[s].length())
                    break go;
                if(strs[s].charAt(index) != prefix)
                    break go;
            }
            result.append(prefix);
            index++;
        }
        return result.toString();
    }
}