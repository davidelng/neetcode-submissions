class Solution {
    public boolean isValid(String s) {
        // if (s.length() == 0) return true;
        // if (s.length() == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            if (
                (c == ')' && stack.peek() != '(') ||
                (c == ']' && stack.peek() != '[') ||
                (c == '}' && stack.peek() != '{')
            ) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
