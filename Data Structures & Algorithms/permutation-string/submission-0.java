class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // We can expand the window until it reaches 's1' length.
        // Since we are looking for a permutation of 's1' we need
        // a window of fixed size. To check if we have a substring
        // we can store the frequencies of 's1' and compare them
        // with the frequencies of each window in 's2'.
        int left = 0, right = 0;
        int[] s1Freq = new int[26], s2Freq = new int[26];

        // Populate 's1Freq'
        for (char c : s1.toCharArray()) {
            // There are only 26 english lowercase letters, so we can
            // find the index of the current char in the frequencies array
            // busing ASCII. Because 'z' is 122 and 'a' is 97, the difference
            // between a char and 'a' will be in range from 0-25.
            int idx = c - 'a';
            s1Freq[idx]++;
        }

        while (right < s2.length()) {
            // Update the current window frequencies with
            // the character at the right pointer.
            int idx = s2.charAt(right) - 'a';
            s2Freq[idx]++;
            // If the window is greater than 's1' we need to
            // fix its size and slide it.
            if ((right-left+1) > s1.length()) {
                // Remove the frequency of the character at left pointer
                // before sliding the window.
                int leftIdx = s2.charAt(left) - 'a';
                s2Freq[leftIdx]--;
                left++;
            }
            // If the frequencies are equal we have a substring.
            if (Arrays.equals(s1Freq, s2Freq)) return true;
            right++;
        }

        return false;
    }
}
