package problem371;

class Solution {
    public int getSum(int a, int b) {
        
        long mask = 1;
        int offset = 0;
        int prevOffset = 0;
        int i = 0;
        long sum = 0;
        while(i <= 33)
        {
            long b1 = a & mask;
            long b2 = b & mask;
            
            if (b1 == b2 && b1 > 0)
            {
                offset = 1;
                b1 = 0;
                b2 = 0;
            }
            else
            {
                offset = 0;
            }
            
            b1 = Math.max(b1, b2);
            
            if (prevOffset == 1)
            {
                b1 = ~b1 & mask;
                if (b1 == 0)
                    offset = 1;
            }
            prevOffset = offset;
            
            sum = sum | b1;
            mask = mask << 1;
            i++;
        }
        
        return (int) sum;
        
    }
}