package problem441;

class Solution {
    public int arrangeCoins(int n) {
        int cnt = 0;
        
        while(n /(cnt + 1) >0) {
            cnt++;
            n -= cnt;  
        }
        
        return cnt;
    }
}