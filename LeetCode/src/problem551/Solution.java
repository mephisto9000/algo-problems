package problem551;

class Solution {
    public boolean checkRecord(String s) {
        
        int acount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='A')
                acount++;
            if (s.charAt(i)=='L' && i>1 && s.charAt(i-1)=='L' && s.charAt(i-2)=='L')
                return false;
        }
        
        if (acount >= 2)
            return false;
        return true;
        
        
    }
}