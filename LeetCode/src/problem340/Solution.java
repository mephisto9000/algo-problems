package problem340;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      
      Map<Character, Integer> map = new HashMap<>();
      int l=0;
      int r,max = 0;
      
      if (k == 0)
        return 0;
      for (r=0; r <s.length();r++) {
        char c = s.charAt(r);
        
        while(!map.containsKey(c) && map.keySet().size()==k) {
          char lc = s.charAt(l++);
          int val = map.get(lc);
          if (val == 1)
            map.remove(lc);
          else
            map.put(lc, val-1);
        }
        int v = map.getOrDefault(c, 0);
        map.put(c,v+1);
        max = Math.max(r-l+1, max);
      }
      return max;
        
    }
}