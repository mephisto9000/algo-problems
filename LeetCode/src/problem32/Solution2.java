package problem32;

class Solution {    
    boolean cleared[];
    int n;    
    public int longestValidParentheses(String s) {        
        n = s.length();
        cleared = new boolean[n];        
        Stack<Integer> st = new Stack();
        for (int i = 0; i < n; i++) {
            if (st.size() > 0 && s.charAt(i) == ')' && s.charAt(st.peek()) == '(') {
                cleared[st.pop()] = true;
                cleared[i] = true;
            } else
                st.add(i);
        }        
        int max = 0;
        int lMax = 0;
        for (int i = 0; i < n; i++) {
            if (cleared[i]) {
                lMax ++;
            } else {
                lMax = 0;
            }
            max = Math.max(max, lMax);                    
        }        
        return max;        
    }         
