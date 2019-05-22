package problem921;

class Solution {
    public int minAddToMakeValid(String S) {
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0;  i< S.length(); i++) {
            char c = S.charAt(i);
            
            if (c == ')' && !st.isEmpty() && st.peek()=='(') {
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        
        return st.size();
        
    }
}