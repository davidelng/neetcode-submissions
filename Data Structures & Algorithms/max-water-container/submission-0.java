class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;
        while (left < right) {
            int h = Math.min(heights[left], heights[right]);
            int water = (right-left) * h;
            maxWater = Math.max(water, maxWater);
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }
}
