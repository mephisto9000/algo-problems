package problem161;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        if (s.equals(t))
            return false;
        
        if (isRem(s,t,false) || isRem(t,s,false)||isRem(s,t,true))
            return true;
        return false;
        
    }
    
    boolean isRem(String s, String t, boolean x) {        
        for (int i = 0; i < s.length(); i++) {
            String a = rem(s,i);
            String b = (x == true) ? rem(t,i) : t;
                    
            if (a.equals(b))
                return true;
        }
        return false;
    }
    
    String rem(String s, int idx) {
        
        if (idx >= s.length())
            return s;
        
        String l = (idx == 0)? "" : s.substring(0,idx);
        String r = (idx >= (s.length()-1))?"":s.substring(idx+1, s.length());
        return l+r;
    }
}