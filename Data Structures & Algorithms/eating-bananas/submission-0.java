class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // The max amount of bananas eaten in an hour
        // correspond to the highest pile in the piles array,
        // because Koko can only eat from one pile per hour.
        // Therefore, the solution is a binary search between
        // the min and the max number of bananas per hour
        // to find the minimum (k) that will empty all piles.
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;
        while (left <= right) {
            int k = left + ((right-left)/2);

            long time = 0;
            for (int p : piles) {
                time += Math.ceil((double) p / k);
            }

            if (time <= h) {
                // If we found a 'k' value that is
                // less then 'h', we keep searching
                // for a smaller value to the left
                res = k;
                right = k - 1;
            } else {
                // If our value exceeds the hours 'h'
                // we need to increase the number of
                // bananas eaten, so we move to the right
                left = k + 1;
            }
        }
        return res;
    }
}
