package problem158;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
  
    char oldBuf[] = new char[4];
    int oldBufNum = 0;
    public int read(char[] buf, int n) {                        
      int ptr = 0;
      
      if (n == 0)
        return 0;
      
      while(oldBufNum > 0) {
        buf[ptr++] = oldBuf[0];
        oldBuf = Arrays.copyOfRange(oldBuf, 1, oldBufNum);
        oldBufNum --;
        if (ptr == n)
          break;
      }
      
      char[] tmpBuf = new char[4];
        for (int j = 0; j < v; j++) {
          if (ptr < n)
            buf[ptr++] = tmpBuf[j]; 
          else {
            oldBuf = Arrays.copyOfRange(tmpBuf, j, v);
            oldBufNum = v - j;
            break;
          }
        }
        if (v < 4)
          break;        
      }      
      return ptr;        
    }
}