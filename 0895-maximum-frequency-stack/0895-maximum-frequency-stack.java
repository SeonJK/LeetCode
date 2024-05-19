class FreqStack {
    
    HashMap<Integer, Stack> stackMap;
    HashMap<Integer, Integer> freqMap;
    
    int maxFreq = 0;

    public FreqStack() {
        stackMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        int freq = freqMap.get(val);
        maxFreq = Math.max(freq, maxFreq);
        
        Stack<Integer> stack = new Stack<>();
        if (stackMap.containsKey(freq)) {
            stack = stackMap.get(freq);
        }
        stack.push(val);
        stackMap.put(freq, stack);
    }
    
    public int pop() {
        Stack<Integer> stack = stackMap.get(maxFreq);
        int ans = stack.pop();
        
        freqMap.put(ans, freqMap.get(ans) - 1);
        if (stackMap.get(maxFreq).size() == 0) {
            stackMap.remove(maxFreq);
            maxFreq--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */