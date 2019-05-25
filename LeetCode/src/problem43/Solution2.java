package problem43;

class Solution {
    public String multiply(String num1, String num2) {
      
      StringBuilder sb = new StringBuilder();
      String[] lines = new String[num1.length()];
      int maxLen = 0;
      for (int i = num1.length()-1; i>= 0; i--) {
        int v1 = num1.charAt(i)-'0';
        int carry = 0;
        
        sb.setLength(0);
        for (int k = num1.length()-1; k > i; k--)
          sb.append('0');
        for (int j = num2.length()-1; j>= 0; j--) {
          int v2 = num2.charAt(j)-'0';

          int x = v1*v2 + carry;
          carry = x/10;
          x = x % 10;          
          sb.append(x);          
        }
        
        if (carry > 0)
          sb.append(carry);
        
        lines[i] = sb.reverse().toString();
        maxLen = Math.max(maxLen, sb.length());        
      }
      
      int carry = 0;
      sb.setLength(0);
      
      int idx = 0;
      
      
      for (int i = 0; i < lines.length; i++)
        System.out.println(lines[i]);
      
      while(idx < maxLen || carry > 0) {
      int v = 0;  
      for (int i = 0; i < lines.length; i++) {
        if (lines[i].length()-1-idx < 0)
          continue;
        v+= lines[i].charAt(lines[i].length()-1-idx) - '0';
      }
      v+=carry;
      carry = v / 10;
      v = v % 10;
      sb.append(v);
      idx++;
      }
      
      sb.reverse();
      while(sb.length()>1 && sb.charAt(0)=='0')
        sb.deleteCharAt(0);
      
      return sb.toString();      
    }
}