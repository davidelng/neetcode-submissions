class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (this.min.isEmpty() || val <= this.min.peek()) {
            this.min.push(val);
        }
    }
    
    public void pop() {
        int val = this.stack.pop();
        if (!this.min.isEmpty() && val == this.min.peek()) {
            this.min.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min.peek();
    }
}
