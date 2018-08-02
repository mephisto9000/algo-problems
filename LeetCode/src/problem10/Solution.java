package problem10;

class Solution {
    
    String s;
    String p;
    
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        
        return rec(0,0);
        
    }
    
    boolean rec(int sIdx, int pIdx) {
        
        if (pIdx >= p.length()) {
            if (sIdx >= s.length())
                return true;
            else
                return false;
        
        }
            
        boolean match = (sIdx < s.length() && (s.charAt(sIdx) ==  p.charAt(pIdx) || p.charAt(pIdx) == '.' ));     
                
        if (pIdx < (p.length()-1) && p.charAt(pIdx+1) == '*') {
            return rec(sIdx, pIdx+2) || (match && rec(sIdx+1, pIdx));
        }
        else {
            return (match && (rec(sIdx+1, pIdx+1)));
        }   
        
    }

}