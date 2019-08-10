package problem777;

class Solution {
    public boolean canTransform(String start, String end) {
      
      char startarr[] = start.toCharArray();
      char endarr[] = end.toCharArray();
      boolean used[] = new boolean[end.length()];
      
      int ls1, ls2 = 0;
      int rs1, rs2 = 0;
      ls1 = 0;
      rs1 = 0;
      for (int i = 0; i < start.length(); i++) {
        if (startarr[i] == 'L')
          ls1++;
        if (endarr[i] == 'L')
          ls2++;
        if (startarr[i] == 'R')
          rs1++;
        if (endarr[i] == 'R')
          rs2 ++;
      }
      
      if (ls1 != ls2 || rs1 != rs2 || start.length() != end.length())
        return false;
      
      for (int i = 0; i < end.length(); i++) {
        if (endarr[i] == 'L') {
          boolean found = false;
          for (int j = i; j < end.length(); j++) {
            if (startarr[j]=='L' && used[j]==false) {
              used[j] = true;
              found = true;
              break;
            }
            if (startarr[j]=='R')
              return false;
          }
          if (!found)
            return false;
        }
        
        if (endarr[i] == 'R') {
          boolean found = false;
          for (int j = i; j >= 0; j --) {
            if (startarr[j]=='R' && used[j]==false) {
              used[j] = true;
              found = true;
              break;
              
            }
            if (startarr[j]=='L')
              return false;
          }
          if (!found)
            return false;
        }
      }
      return true;
        
    }
}