package problem214;

class Solution {
    public String shortestPalindrome(String s) {
      
      int prime = 113;
      int base = 26;
      int h = 0;
      int hinv = 0;
      int idx = -1;
      int power = 0;
      for (int i = 0; i < s.length(); i++) {
        h = (h*base + s.charAt(i)) % prime;
        power = (i == 0) ? 1 : ((power * base) % prime);
        hinv = (power * s.charAt(i) + hinv) % prime;
        
        if (h == hinv) { 
          String sub = s.substring(0, i+1);
          StringBuilder sb = new StringBuilder();
          sb.append(sub);
          String inv = sb.reverse().toString();
          
          if (sub.equals(inv)) {
            idx = i;
          }
        }
      }
      
      StringBuffer sb = new StringBuffer();
      sb.append(s.substring(idx+1, s.length()));
      return sb.reverse().toString() + s;
        
        
    }
}