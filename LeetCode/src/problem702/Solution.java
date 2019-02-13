package problem702;

class Solution {
    
    final int NOT_FOUND = 2147483647;
    public int search(ArrayReader reader, int target) {
        
        
        int p = 1;
        
        while(true) {
            int v = reader.get(p-1);
            
            if (v == NOT_FOUND || v >target)
                break;
            p = p << 1;
        }
        
        int l = 0;//(p >> 1) + 1;
        int r = p-1;
        
        while(l <= r) {
            int m = (l + r)/2;
            
            int v = reader.get(m);
            
            if (v == target)
                return m;
            if (v == NOT_FOUND || v > target)
                r = m-1;
            else
                l = m+1;
        }
        return -1;
    }
}