package problem438;

class Solution {
	  
    int pcnt[] = new int[26];
    int rollcnt[] = new int[26];
      
    public List<Integer> findAnagrams(String s, String p) {                 
      List<Integer> ans = new LinkedList<>();
      int plen = p.length();
      int slen = s.length();
      
      for (int i = 0; i < plen; i++) {
        int idx = p.charAt(i) - 'a';
        pcnt[idx] ++;
      }
            
      for (int i = 0; i < slen; i++) {        
        if (i >= plen) {
          int idx = s.charAt(i-plen) - 'a';
          rollcnt[idx] --;
        }        
        int idx = s.charAt(i) - 'a';
        rollcnt[idx] ++;                                
        if (isSame()) {
          ans.add(i - plen+1);
        }          
      }      
      return ans;      
    }
    
    boolean isSame() {
      for (int i = 0; i < 26; i++) {
        if (pcnt[i]!=rollcnt[i]) {
          return false;
        }
      }
      return true;
    }
}