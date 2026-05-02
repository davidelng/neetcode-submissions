class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 1;
        for (int n : nums) {
            if (set.contains(n-1)) {
                continue;
            }
            int curr = 1;
            int i = n;
            while (set.contains(i+1)) {
                i++;
                curr++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
