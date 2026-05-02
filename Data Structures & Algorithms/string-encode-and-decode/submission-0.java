class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder currLen = new StringBuilder();
            while (str.charAt(i) != '#') {
                currLen.append(str.charAt(i));
                i++;
            }
            i++;
            int wordLen = Integer.parseInt(currLen.toString());
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i+wordLen; j++) {
                sb.append(str.charAt(j));
            }
            strs.add(sb.toString());
            i += wordLen-1;
        }
        return strs;
    }
}
