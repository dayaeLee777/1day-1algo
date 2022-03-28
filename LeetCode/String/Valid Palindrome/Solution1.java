class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        for(char c : s.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
                sb.append(c);
        }

        String alphanumeric = sb.toString();
        int size = alphanumeric.length();

        for(int i = 0; i < size / 2; i++)
            if(alphanumeric.charAt(i) != alphanumeric.charAt(size - i - 1))
                return false;

        return true;
    }
}