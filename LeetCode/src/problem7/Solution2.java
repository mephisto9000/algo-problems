package problem7;

class Solution {
    public int reverse(int x) {
      
      long rev = 0;      
      while(x != 0) {
        int v = x % 10;
        x = x/10;
        rev = rev*10 + v;
      }
      
      if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE)
        rev = 0;
      
      return (int) rev;        
    }
}