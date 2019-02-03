package problem856;

class Solution {
    
    Stack<Integer> stack;
    public int scoreOfParentheses(String S) {
        
        stack = new Stack();
        
        for (int i = 0 ; i < S.length(); i++) {
            char c = S.charAt(i);
            
            if (c=='(')
                stack.push(-1);
            else {
                int top = stack.pop();
                if (top > 0) {
                    stack.pop();
                    int add = (top*2);
                    if (!stack.isEmpty() && stack.peek() > 0) 
                        stack.push(stack.pop()+add);
                    else
                        stack.push(add);
                } else {
                    if (!stack.isEmpty() && stack.peek() > 0) 
                        stack.push(stack.pop()+1);
                    else
                        stack.push(1);
                }
            }
        }
        
        return stack.pop();
    }
}