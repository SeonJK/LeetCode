class MinStack {

    Stack<Pair> stack;
    int minValue = Integer.MAX_VALUE;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        minValue = Math.min(val, minValue);
        System.out.println("push() :: minValue=" + minValue + ", val="+val);
        stack.push(new Pair(val, minValue));
        System.out.println("push()2 :: s.minValue=" + stack.peek().getMinValue() + ", s.val="+stack.peek().getVal());
    }
    
    public void pop() {
        stack.pop();
        if (!stack.empty()) {
            minValue = stack.peek().getMinValue();
            System.out.println("pop() :: minValue=" + minValue + ", val="+ stack.peek().getVal());
        } else {
            minValue = Integer.MAX_VALUE;
            System.out.println("pop() :: minValue=" + minValue);
        }
    }
    
    public int top() {
        System.out.println("top() :: minValue=" + minValue + ", val="+stack.peek().getVal() + ", s.min=" + stack.peek().getMinValue());
        return stack.peek().getVal();
    }
    
    public int getMin() {
        System.out.println("getMin() :: minValue=" + minValue + ", val="+ stack.peek().getVal() + ", s.min=" + stack.peek().getMinValue());
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