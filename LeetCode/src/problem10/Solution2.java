package problem10;

class Solution {
    public boolean isMatch(String s, String p) {      
      return regex(s,p,0,0);        
    }
  
  boolean regex(String s, String p, int sidx, int pidx) {
    if (sidx == s.length()) {
      
      while(pidx < p.length()-1 && p.charAt(pidx+1)=='*') {        
        pidx += 2;
      }
      
      if (pidx == p.length() )
        return true;
      return false;
    }
    
    if (pidx == p.length())
      return false;
    
    char schar = s.charAt(sidx);
    char pchar = p.charAt(pidx);
    
    if (pidx < p.length()-1 && p.charAt(pidx+1)=='*') {
      boolean ans = regex(s,p, sidx, pidx+2); // zero
      if (schar == pchar || pchar == '.')
        ans = ans || regex(s,p,sidx+1, pidx); //same
      
      return ans;
    }
      
    //equal
    if (schar == pchar || pchar == '.')
      return regex(s,p,sidx+1,pidx+1);
    
    return false;
  }
}