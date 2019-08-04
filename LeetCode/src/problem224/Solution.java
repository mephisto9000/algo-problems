package problem224;

class Solution {
    public int calculate(String s) {
        int sum = 0;
        
        int curNum = 0;
        int sign = 1;
        
        Stack<Integer> st = new Stack<>();
        
        int idx = 0;
        while(idx < s.length()) {
                                        
            char c = s.charAt(idx);
            
            if (!(c>='0' && c <='9')) {
                if (curNum!=0) {
                    sum = sum + curNum*sign;
                    curNum = 0;
                }
            }
            
            if (c == '+') {                
                sign = 1; 
            }
            else if (c == '-') {
                if (curNum!=0) {
                    sum = sum + curNum*sign;
                    curNum = 0;
                }
                sign = -1;
            }
            else 
            if (c == '(')  {
                while(st.size() > 0 || s.charAt(idx) == '(') {
                    
                if (s.charAt(idx)=='(') {
                    st.add(idx);
                } else 
                if (s.charAt(idx) == ')') {
                    int i1 = st.pop();
                
                        if (st.size() == 0) {
                            curNum = calculate(s.substring(i1+1, idx));
                            sum += curNum * sign;
                            curNum = 0;
                            break;
                        }
                
                    }
                    idx++;
                }
            }
            else
            if (c  >= '0' && c <= '9') {
                int v = c - '0';
                curNum = curNum*10 + v;
            }
            idx++;
        }
        
        if (curNum != 0)
            sum += curNum*sign;
                
        return sum;
        
    }
}