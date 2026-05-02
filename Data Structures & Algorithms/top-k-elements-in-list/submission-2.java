class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // frequencies map number -> frequency
        Map<Integer, Integer> count = new HashMap<>();
        // frequencies buckets
        // each number can appears at max n times
        // so we can have n buckets that store
        // frequency -> numbers having that frequency
        List<Integer>[] freq = new List[nums.length+1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // get frequencies
        for (int n : nums) {
            count.put(n, count.getOrDefault(n,0)+1);
        }
        // populate buckets
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        // build res
        int[] res = new int[k];
        int index = 0;
        // iterate over the buckets from the end
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            // add each bucket entry
            for (int n : freq[i]) {
                res[index++] = n;
                // if the bucket has >= k entry, we can stop
                if (index == k) return res;
            }
        }
        return res;
    }
}
