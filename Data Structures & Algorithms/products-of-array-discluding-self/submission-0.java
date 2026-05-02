class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
                continue;
            }
            prefix[i] = nums[i] * prefix[i-1];
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (i == nums.length-1) {
                suffix[i] = nums[i];
                continue;
            }
            suffix[i] = nums[i] * suffix[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = suffix[i+1];
            } else if (i == nums.length-1) {
                res[i] = prefix[i-1];
            } else {
                res[i] = suffix[i+1] * prefix[i-1];
            }
        }
        return res;
    }
}  
