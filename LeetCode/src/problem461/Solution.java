package problem461;

class Solution {
    public int hammingDistance(int x, int y) {
        
        int w = x^y;
        
        int cnt = 0;
        while(w != 0) {
            int ww = w & 1;
            if (ww == 1)
                cnt++;
            w = w>>1;
        }
        return cnt;
    }
}