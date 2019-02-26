package problem20;

class Solution {
    
    char rightToLeft(char c) {
        if (c == '}')
            return '{';
        if (c == ']')
            return '[';
        return '(';
    }
    
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        Set<Character> left = new HashSet<>(Arrays.asList('{', '[', '('));
        
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.contains(c)) {
                st.push(c);
            } else {
                char c1 = rightToLeft(c);
                if (st.size() > 0 && st.peek() == c1)
                    st.pop();
                else
                    st.push(c);
            }
        }
        
        return st.size() == 0;                
    }
    
    
}