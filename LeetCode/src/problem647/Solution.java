package problem647;

class Solution {
    
	   
    public int countSubstrings(String s) {
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
           
            for (int j = i+1; j <= s.length(); j++)
            {
                String tmp = s.substring(i, j);
                if (isPalendrome(tmp))
                    count ++;
                
            }
        }
        return count;
        
    }
    
    boolean isPalendrome(String s)
    {
        int i = 0; 
        int j = s.length() - 1;
        
        while(i < j)
        {
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}