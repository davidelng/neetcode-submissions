class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        // The idea here is that the difference between a
        // heigher column and a shorter one is the amount of
        // water we can trap for that particular index.
        // We cannot take into consideration the smaller column
        // as water because it's solid, thus we can only trap water
        // from the top of the smaller column to the edge of the higher
        // column. Also, we cannot take the boundaries like 0 and height.length
        // into considerations, because they cannot contain water,
        // therefore we always skip them.
        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        int maxWater = 0;

        while (left < right) {
            // The amount of water at each index is:
            // max wall seen on current side - height at current index.
            // We keep calculating water between two left walls
            // until we hit a higher wall than right.
            // At that point we keep calculating water between two right walls,
            // until we hit a smaller wall than left.
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                maxWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                maxWater += rightMax - height[right];
            }
        }

        return maxWater;
    }
}
