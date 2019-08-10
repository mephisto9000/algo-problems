package problem301;

class Solution {
    
    Set<String> ansSet = new HashSet<>();
    String s;
    public List<String> removeInvalidParentheses(String s) {
        
        int cnt = validity(s);
        this.s = s;
        
        rec(cnt,0,new StringBuffer());
        return new LinkedList(ansSet);
    }
    
    void rec(int cnt, int idx, StringBuffer sb) {
        
        if (idx == s.length()) {
            if (validity(sb.toString()) == 0) {
                ansSet.add(sb.toString());
            }    
            return;
        }
        
        char c = s.charAt(idx);
        sb.append(c);
        rec(cnt, idx+1, sb);
        sb.setLength(sb.length()-1);
        if (c == ')' || c == '(') {
            if (cnt > 0) {
                rec(cnt-1, idx+1, sb);
            }
        }                
    }
    
    int validity(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='(') {
                st.push(c);
            } 
            if (c == ')')
            {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }
        
        return st.size();
    }
}