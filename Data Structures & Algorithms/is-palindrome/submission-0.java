class Solution {
    public static boolean isAlnum(char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Solution.isAlnum(s.charAt(left))) {
                left++;
            }
            while (left < right && !Solution.isAlnum(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;    
        }
        return true;
    }
}
