package problem276;

class Solution {
    
    int k;
    int n;
    
    int memo[][];
    public int numWays(int n, int k) {
        this.n = n;
        this.k = k;
        
        memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
            
        
        if (n ==0 || k == 0)
            return 0;
        return rec(0, -1, 1);
    }
    
    
    int rec(int idx, int prevColor, int prevColorCount) {        
        if (idx >= n)
            return 1;
        
        if (memo[idx][prevColorCount-1] != -1)
            return memo[idx][prevColorCount-1];
        
        int ans = 0;
        
        for (int i = 0; i < k; i++ ) {
            
                if (i == prevColor && prevColorCount == 2)
                    continue;
                ans += rec(idx+1, i, i == prevColor? prevColorCount+1: 1);
                                        
        }         
        memo[idx][prevColorCount-1] = ans;
        return ans;
    }
}