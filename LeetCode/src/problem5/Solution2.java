package problem5;

class Solution {
    public String longestPalindrome(String s) {
      
      String max = "";
      for (int i = 0; i < s.length(); i++) {
        String local = maxPoly(s, i,false);
        if (local.length() > max.length())
          max = local;
        if (i + 1 < s.length() && s.charAt(i)==s.charAt(i+1)) {
          local = maxPoly(s,i,true);
          if (local.length() > max.length())
          max = local;
        }
      }
      return max;
              
    }
  
  String maxPoly(String s, int idx, boolean char2) {
    StringBuilder sb = new StringBuilder();
    
    sb.append(s.charAt(idx));
    int l = idx-1;
    int r = idx+1;
    if (char2) {
      sb.append(s.charAt(idx+1));
      r++;
    }
    while(l >= 0 && r < s.length()) {
      char lc = s.charAt(l--);
      char rc = s.charAt(r++);
      if (lc!=rc)
        break;
      sb.insert(0,lc);
      sb.append(rc);
    }
    return sb.toString();
    
  }
  
  
}