package problem242;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        char a1[] = s.toCharArray();
        char a2[] = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        for (int i = 0; i < a1.length; i++) 
            if (a1[i]!=a2[i])
                return false;
        
        return true;
        
    }
}