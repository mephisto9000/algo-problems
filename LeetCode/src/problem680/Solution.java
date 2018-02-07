package problem680;

class Solution {
    public boolean validPalindrome(String s) {                
        return isPoly(s, 0);        
    }
    
    boolean isPoly(String s, int cnt)
    {
        int i = 0; 
        int j = s.length() - 1;
        
        
        
        while(i < j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                
                if (cnt > 0)
                    return false; 
                
                                 
               String s1 = s.substring(0, i) + s.substring(i+1, s.length());
               String s2 = s.substring(0, j) + s.substring(j+1, s.length());
                
               if (isPoly(s1, 1) || isPoly(s2, 1)) 
                   return true;
                else
                    return false;
                
            }
            i++;
            j--;
        }
        return true;        
    }
}