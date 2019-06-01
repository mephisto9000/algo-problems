package problem22;

class Solution {
    
    List<String> ans ;
    public List<String> generateParenthesis(int n) {
       StringBuffer sb = new StringBuffer();
       ans = new LinkedList<>();
       rec(n, 0, sb); 
       return ans;
       
    }
    
    void rec(int n, int sides, StringBuffer sb) {
        
        if (n == 0 ) {
            for (int i = 0; i < sides; i++)
                sb.append(')');
            if (sb.length() > 0)
                ans.add(sb.toString());
            
            sb.setLength(sb.length()-sides);
            return;
        }
        
        
        sb.append('(');
        rec(n-1, sides+1, sb);
        sb.setLength(sb.length()-1);
        
        if (sides > 0) {
            sb.append(')');
            rec(n, sides - 1, sb);
            sb.setLength(sb.length()-1);
        }
         
    }
    
    
}