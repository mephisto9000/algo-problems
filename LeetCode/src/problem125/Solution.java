package problem125;

class Solution {
    public boolean isPalindrome(String s) {
        
        if (s == null)
            return true;
        
        String tmp = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        
        int i = 0;
        int j = tmp.length()-1;
        
        while(i < j)
        {
            if (tmp.charAt(i)!=tmp.charAt(j))
                return false;
            
            i++;
            j--;
        }
        return true;
        
    }
}