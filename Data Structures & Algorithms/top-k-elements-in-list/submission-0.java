class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // track frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        // build a list of [frequency, number]
        List<int[]> bin = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            bin.add(new int[]{entry.getValue(), entry.getKey()});
        }
        // sort the list by frequencies
        bin.sort((a,b) -> b[0] - a[0]);
        // return the top k elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // return only numbers
            res[i] = bin.get(i)[1];
        }
        return res;
    }
}
