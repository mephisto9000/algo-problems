package problem338;

class Solution {
    
    int mask = 0xFFFF;
    int maskWidth = 16;
    
    int bitCache[];
    
    public int[] countBits(int num) {
        
        int counts[] = new int[num+1];
        bitCache = new int[mask+1];
        
        for (int i = 0; i <= mask; i++)
        {
            int c = 0;
            int j = i;
            while (j > 0)
            {
                c += j & 1;
                j = j >> 1;
            }
            
            bitCache[i] = c;
        }
        
        for (int i = 0; i <= num; i++)
            counts[  i] = cb(i);
        
        return counts;
    }
    
    int cb(int v)
    {
        int ans = bitCache[v & mask] + bitCache[(v >> maskWidth) & mask];
        return ans;
        
    }
}