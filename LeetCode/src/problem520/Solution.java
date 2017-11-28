package problem520;

class Solution {
    public boolean detectCapitalUse(String word) {
        
        if (word == null || word.length() == 0)
            return false;
        
        int caps = 0;
        int n = word.length();
        boolean firstCap = false;
  
        for(int i = 1; i < n; i++)
        {
            char c = word.charAt(i);
            if (isCap(c))
                caps ++;
             
        }
        
        if (isCap(word.charAt(0)))
            firstCap = true;
        
        if (caps == n-1 && firstCap)
            return true;
        
        if (caps == 0 && !firstCap)
            return true;
            
        if (caps == 0 && firstCap  )
            return true;
        
        return false;
        
    }
    
    boolean isCap(char c)
    {
         return Character.isUpperCase(c);
    }
}