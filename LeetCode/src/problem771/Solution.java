package problem771;

class Solution {
    public int numJewelsInStones(String J, String S) {
        
        Set<Character> jewels = new HashSet();
        int ans = 0;
        
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));                        
        }
        
        for (int i = 0; i < S.length(); i++) {
            char c  = S.charAt(i);
            if (jewels.contains(c)) {
                ans ++;
            }
        }
        
        return ans;
        
    }
}