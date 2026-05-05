class Solution {
    public int characterReplacement(String s, int k) {
        // We can use a sliding window to get the longest substring
        // of repeating character replacing only up to 'k' characters.
        int maxLen = 0;
        int highestFreq = 0;
        int left = 0, right = 0;
        // Store the frequencies of the char in the current window.
        HashMap<Character,Integer> map = new HashMap<>();
        while (right < s.length()) {
            // Update the frequency of the character at the right pointer.
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            // Check if the current character is the one with the highest frequency.
            highestFreq = Math.max(highestFreq, map.get(s.charAt(right)));
            // Since no smaller window will provide a greater maxLen,
            // we can use a fixed size sliding window.
            if ((right-left+1)-highestFreq > k) {
                // Decrease the frequency of the character at the left pointer
                // before moving the window, we need to track only
                // the current window.
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            // Update max length with the window size.
            maxLen = Math.max(maxLen, right-left+1);
            // Increase the right pointer.
            right++;
        }
        return maxLen;
    }
}
