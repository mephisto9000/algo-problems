package problem29;

class Solution {
    public int divide(int dividend, int divisor) {
        

        int sign = 1;
        
        if (Math.signum(dividend) != Math.signum(divisor))
        	sign = -1;
        
        if (divisor == -1 || divisor == 1)
        {
            long ans = (long) dividend * (long) divisor;
            
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return dividend * divisor;
        } 
        
        long dividend1 = dividend;
        long divisor1 = divisor;
        if (dividend1 < 0)
        	dividend1 = -dividend1; //Math.abs(divisor);
        
        if (divisor1 < 0)
        	divisor1 = -divisor1;
        
        if (dividend1 - divisor1 < 0)
        	return 0;
        
        long j = dividend1;
        long i = 1;
        
        long m = dividend1  >> 1;
        
        long prev = Integer.MAX_VALUE;
        long tmp = (long) m * divisor1;
        while (tmp != (long) dividend1)
        {

            if (prev == m)
                break;
            
            if (tmp >  dividend1)
                j = m; 
            else
                i = m; 
            
            prev = m;
            long z = i + j;
            z = z>>1;
            m = (int) z;
            tmp = (long) m * divisor1;
        }
        
        long ans = (long) m * divisor1;
        long ans1 = ((long) (m+1)) * divisor1;
        
        if (ans < dividend1 && ans1 <= dividend1)
            m++;
        
        return (int) m*sign;
    }
}