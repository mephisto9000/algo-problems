package problem844;

class Solution {
    public boolean backspaceCompare(String S, String T) {
    
        int sc = 0;
        int tc = 0;
        int sidx = S.length()-1;
        int tidx = T.length()-1;
        while(sidx >= 0 || tidx >= 0) { 
            char sv;
            char tv;
            while(sidx >=0) {
                sv = S.charAt(sidx);
                if (sv == '#') {
                    sc++;
                    sidx--;
                } else {
                    if (sc > 0) {
                        sidx--;
                        sc--;
                    } else
                        break;
                }                
            }
            
            while(tidx >= 0) {
                tv = T.charAt(tidx);
                if (tv == '#') {
                    tc++;
                    tidx --;
                } else {
                    if (tc > 0) {
                        tidx--;
                        tc--;
                    } else
                        break;
                }
            }
             
            sv = sidx >= 0 ? S.charAt(sidx) : '@';
            tv = tidx >= 0 ? T.charAt(tidx) : '@';
            
            System.out.println(sv+" "+tv);
            if (sv!=tv)
                return false;
            sidx--;
            tidx--;
                                    
        }  
        
        if (sidx >= 0 || tidx >= 0)
            return false;
        
        
        return true;
        
    }        
}