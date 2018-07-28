package problem301;

class Solution {
    Set<String> ans;
    String s;
    int ansSize = -1;
    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet();
        this.s = s;
        rec(new StringBuffer(), new Stack(),  0);
        
        List<String> a = new LinkedList();
        a.addAll(ans);
        return a;  
            
        
        
    }
    
    void rec(StringBuffer sb, Stack<Character> st,   int idx) {
        if (idx >= s.length()) {
            if (st.size() == 0) {
                                
                if (ansSize <= sb.length()) {
                    
                    ans.add(sb.toString());            
                    ansSize = sb.length();
                }
            }
            
            return;
        }
        
        char c = s.charAt(idx);
        if (c == '(' || c == ')') {
        if (c == '(') {
            st.add('(');
            sb.append(c);
            rec(sb,st, idx + 1);
            st.pop();
            sb.setLength(sb.length() - 1);
        }
        
        if (c == ')') {
            if (st.size() > 0) {
            st.pop();
            sb.append(c);
            rec(sb,st, idx+1);
            st.push('(');
            sb.setLength(sb.length() - 1);    
            }
        }
           rec(sb, st, idx +1); 
        }
        else { 
            sb.append(c);
            rec(sb, st, idx +1); 
            sb.setLength(sb.length() - 1);  
        }
                                                
    }
}