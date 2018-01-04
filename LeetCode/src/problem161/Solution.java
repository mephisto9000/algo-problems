package problem161;

class Solution {
    
    String s1;
    String s2;
    int len1;
    int len2;
    
    
    
    public boolean isOneEditDistance(String s, String t) {
        s1 = s;
        s2 = t;
        len1 = s1.length();
        len2 = s2.length();
        
        
        if (cmpEdit() == 1)
            return true;
        if (cmpDel() == 1)
            return true;
        
        return false;
    }
    
    int cmpDel()
    {
        int idx1 = 0;
        int idx2 = 0;
        int cnt = 0;
        while(idx1 < len1 && idx2 < len2)
        {
            if (s1.charAt(idx1) == s2.charAt(idx2))
            {
                idx1++;
                idx2++;
                continue;            
            }
            cnt++;
            if (len1>len2)
                idx1++;
            else
                idx2++;
            
            if (cnt > 1)
                break;
        }
         if (idx1>=len1 && idx2 >= len2)
            return cnt;
        
        if (idx1 >= len1)
        {
            
            return s2.length()-idx2 + cnt;
        }
        
        if (idx2 >= len2)
            return s1.length() - idx1 + cnt;
        
         return 0;
        }
        
    
    
    int cmpEdit()
    {
        int idx1 = 0;
        int idx2 = 0;
        int cnt = 0;
        while(idx1 < len1 && idx2 < len2)
        {
            if (s1.charAt(idx1) == s2.charAt(idx2))
            {
                idx1++;
                idx2++;
                continue;            
            }
            cnt++;
            idx1++;
            idx2++;
            if (cnt > 1)
                break;
        }
        
        if (idx1>=len1 && idx2 >= len2)
            return cnt;
        
        if (idx1 >= len1)
        {
            
            return s2.length()-idx2 + cnt;
        }
        
        if (idx2 >= len2)
            return s1.length() - idx1 + cnt;
        
         return 0;
        }
    
}