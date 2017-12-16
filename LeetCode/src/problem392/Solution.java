package problem392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int sn = s.length();
        int tn = t.length();
        
        if (s == null || s.length()==0)
            return true;
        
        int sidx = 0;
        int tidx = 0;
        int cnt = 0;
        
        
        while(tidx < tn)
        {
            char sc = s.charAt(sidx);
            char tc = t.charAt(tidx);
            
            if (sc == tc)
            {
                cnt ++;
                sidx ++;
                
                if (cnt == sn)
                    return true;
            }
            
            tidx ++;
        }
        return false;
        
        
    }
}