package problem247;

class Solution {
    
    List<String> ans;
    public List<String> findStrobogrammatic(int n) {
        ans = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        rec(sb, n);
        return ans;
    }
    
    void rec(StringBuilder sb, int n) {
        
        if (sb.length() > n)
            return;
        
        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }
        
        if (sb.length() == 0 && n % 2 != 0) {
            trigger(sb,'0',null,n);
            trigger(sb,'1',null,n);
            trigger(sb,'8',null,n);
             }
            else {
            if ( sb.length() != n-2 )    
                trigger(sb,'0','0',n);    
            trigger(sb,'1','1',n);
            trigger(sb,'8','8',n);
            trigger(sb,'6','9',n);
            trigger(sb,'9','6',n);
            }
    }
    
    
    void trigger(StringBuilder sb, Character pref, Character suf, int n) {
        sb.insert(0, pref);
        if (suf!=null)
            sb.append(suf);
        rec(sb, n);
        sb.deleteCharAt(0);
        if (suf != null)
            sb.deleteCharAt(sb.length()-1);
    }
    
    
}