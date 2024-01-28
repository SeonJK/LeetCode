class Solution {
    final String PLUS = "+";
    final String MINUS = "-";
    final String MULTIPLY = "*";
    final String DIVIDER = "/";
    
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String y, x = "-1";
        
        for (int i = 0; i< tokens.length; i++) {
            if (PLUS.equals(tokens[i])) {
                x = Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()));
            } else if (MINUS.equals(tokens[i])) {
                y = stack.pop();
                x = Integer.toString(Integer.parseInt(stack.pop()) - Integer.parseInt(y));
            } else if (MULTIPLY.equals(tokens[i])) {
                 x = Integer.toString(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()));
            } else if (DIVIDER.equals(tokens[i])) {
                y = stack.pop();
                x = Integer.toString(Integer.parseInt(stack.pop()) / Integer.parseInt(y));
            } else {
                x = tokens[i];
            }
            
            stack.push(x);
        }
        
        return Integer.parseInt(x);
    }
}