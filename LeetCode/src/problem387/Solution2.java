package problem387;

class Solution {
  
    
    public int firstUniqChar(String s) {
      
      int lim = Integer.MAX_VALUE;
      int memo[] = new int[26];
      Arrays.fill(memo, lim);
      
      for (int i = 0; i < s.length(); i++) {
        int idx = s.charAt(i) - 'a';
        if (memo[idx] == lim) {
          memo[idx] = idx;
        } else         
        if (memo[idx] >= 0) {
          memo[idx] = -2;
        } else {
          memo[idx] --;
        }
      }
      
      
      
      
      for (int i = 0; i < s.length(); i++) {
        int idx = s.charAt(i) - 'a';
        if (memo[idx] < lim && memo[idx] >= 0) {
          return i;          
        }
      }
      
      return -1;
        
    }
}