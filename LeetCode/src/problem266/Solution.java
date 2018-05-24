package problem266;

class Solution {
    public boolean canPermutePalindrome(String s) {
        //int alph[] = new int[26];
        Set<Character> set = new HashSet();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        
        if (set.size() < 2)
            return true;
        else
            return false;
        
    }
}