class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        if (!min.isEmpty() && val == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
