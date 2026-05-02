class Solution {
    public int lengthOfLongestSubstring(String s) {
        // edge case
        if (s.length() == 0) return 0;

        // hashset of characters currently in the window
        HashSet<Character> windowChars = new HashSet<>();

        char[] charArr = s.toCharArray();

        int longestSubstring = 1;

        int left = 0;
        for (int right = 0; right < charArr.length; right++) {
            // if set has char then we have a duplicate
            if (windowChars.contains(charArr[right])) {
                // empty set and progress left until no duplicate
                while (windowChars.contains(charArr[right])) {
                    windowChars.remove(charArr[left]);
                    left++;
                }
                // windowChars.add(charArr[left]);
            }
            // else, we add char to set and progress with right
            windowChars.add(charArr[right]);

            // calc longest as right-left+1
            int currentSubsLength = right-left+1;
            longestSubstring = Math.max(longestSubstring, currentSubsLength);
        }

        return longestSubstring;
    }
}
