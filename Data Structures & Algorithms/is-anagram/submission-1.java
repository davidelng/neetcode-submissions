class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c)) return false;
            if ((sMap.get(c) - 1) == 0) {
                sMap.remove(c);
            } else {
                sMap.put(c, sMap.get(c)-1);
            }
        }
        return sMap.size() == 0;
    }
}
