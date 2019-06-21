package problem394;

class Solution {
    
	 
    public String decodeString(String s) {
 
      return process(s,0, s.length()-1);
    }
  
  String process(String s, int start, int end) {
    StringBuffer sb = new StringBuffer();
    
    int cnt = 0;
    int idx  = start;
      while(idx <= end) {
        System.out.println(idx);
        char c = s.charAt(idx);
        if (c >= '0' && c <= '9')
          cnt = 10*cnt + (c-'0');
        else
        if (c == '[') {
                    
          // find last before ]
 
          int bCount = 0;
          int lastIdx = idx+1;
           while(true) {
            char x  = s.charAt(lastIdx);
            if (x=='[')
              bCount++;
            else
            if (x==']') {
              if (bCount == 0)
                break;
              else
                bCount --;
            }
            lastIdx++;
          }

          String repStr = process(s,idx+1, lastIdx);
          for (int i = 0; i < cnt; i++) {
            sb.append(repStr);
          }
          
          idx = lastIdx;
          cnt = 0;
        } else
 
         if ( Character.isLetter(c))
          sb.append(c);
        idx++;        
      }
    return sb.toString();
  }
}