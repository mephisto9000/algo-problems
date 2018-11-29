package problem69;

public class Solution {
    public int mySqrt(int x) {        
        int l = 0;
        int r = x;        
        long msq;
        while (l <= r) {
            int m =  l + (r-l)/2;            
            msq = (long)m * (long)m;                        
            if (msq == x)
                return m;
            if (msq < x)
                l = m+1;
            else
                r = m-1;
        }
        msq = (long)l * (long)l;
        if (msq > x)
            return l-1;
        return l;                
    }
}