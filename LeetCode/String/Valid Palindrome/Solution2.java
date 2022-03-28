class Solution {
    public boolean isPalindrome(String s) {
        String alphanumeric = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuffer(alphanumeric).reverse().toString();
        return alphanumeric.equals(reverse);
    }
}