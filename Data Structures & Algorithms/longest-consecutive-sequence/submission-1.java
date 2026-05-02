class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 1;
        for (int n : nums) {
            if (set.contains(n-1)) {
                continue;
            }
            int curr = 1;
            while (set.contains(n+curr)) {
                curr++;
            }
            longest = Math.max(longest, curr);
        }
        return longest;
    }
}
