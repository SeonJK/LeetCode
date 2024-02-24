class MinStack {

    Stack<Pair> stack;
    int minValue = Integer.MAX_VALUE;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        minValue = Math.min(val, minValue);
        stack.push(new Pair(val, minValue));
    }
    
    public void pop() {
        stack.pop();
        if (!stack.empty())
            minValue = stack.peek().getMinValue();
        else
            minValue = Integer.MAX_VALUE;
    }
    
    public int top() {
        return stack.peek().getVal();
    }
    
    public int getMin() {
        return minValue;
    }
}

class Pair {
    
    private int val;
    private int minValue;
    
    public Pair(int val, int minVal) {
        this.val = val;
        this.minValue = minVal;
    }
    
    public int getVal() { return val; }
    public int getMinValue() { return minValue; }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */