package problem946;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
                                
        Stack<Integer> st = new Stack();
        Stack<Integer> pops = new Stack();
        int n = pushed.length;
                
        for (int i = popped.length-1; i >=0; i--) 
            pops.push(popped[i]);
        
        for (int i = 0; i < n; i++) {
            int v = pushed[i];
            st.push(v);
            while(!st.isEmpty() && st.peek().equals(pops.peek())) {
                st.pop();
                pops.pop();            
            }
        }
                         
        return (pops.size() == 0);
         
    }
}