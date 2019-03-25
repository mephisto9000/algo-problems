package problem139;

class Solution {
    
    
    Set<String> words;
    int memo[];
    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
      memo = new int[s.length()];
      Arrays.fill(memo, -1);
      return rec(0, s);
      
     
    }
  
    boolean rec(int idx, String s ) {
      if (idx >= s.length())
        return true;
      
      if (memo[idx]!=-1) {
        return memo[idx]==1?true:false;
      }
      StringBuffer sb = new StringBuffer();
            
      for (int i = idx; i < s.length(); i++) {
        
        char c = s.charAt(i);
        sb.append(c);
        
        if (words.contains(sb.toString())&& rec(i+1, s)) {
            memo[idx] = 1;
            return true;
        }
      }
      memo[idx] = 0;
      return false;
    }
}