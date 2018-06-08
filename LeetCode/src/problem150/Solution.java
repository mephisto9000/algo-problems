package problem150;

class Solution {
    
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();
        
        for (String s : tokens) {
            if (isSign(s)) {
                int b = stack.pop();
                int a = stack.pop();
                int v = operate(a,b,s);
                stack.push(v);
            }
            else
                stack.push(Integer.parseInt(s));
        }
        
        return stack.pop();
        
    }
    
    boolean isSign(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
    
    int operate(int a, int b, String s) {
        if (s.equals("+"))
            return a + b;
        
        if (s.equals("-"))
            return a - b;
        
        if (s.equals("*"))
            return a*b;
        
        if (s.equals("/"))
            return a / b;
        
        return 0;
            
    }
}