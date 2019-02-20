package problem125;

class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)||Character.isLetter(c))
                sb.append(c);
        }
        s = sb.toString();
        int l = 0;
        int r = s.length()-1;
        
        while(l<=r) {
            if (s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
        
    }
}