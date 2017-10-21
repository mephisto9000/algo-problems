package problem326;

class Solution {
    public boolean isPowerOfThree(int n) {
        
        long v = 1;
        
        while( v < n)
        {
            v *= 3;
        }
        
        if (v == n)
            return true;
        return false;
    }
}