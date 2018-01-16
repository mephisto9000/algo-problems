package problem309;

class Solution {
    
    final int BUY = 0;
    final int SELL = 1;
    
    int memo[][];
    int prices[];
    int n;
    
    public int maxProfit(int[] prices) {
        
        n = prices.length;
        this.prices = prices;
        
        memo = new int[n][2];
        
        for (int i = 0; i < n; i++)
        {
            memo[i][BUY] = -1;
            memo[i][SELL] = -1;
        }
        
        return rec(0, BUY);
    }
        
    int rec(int idx, int ttype)
    {
        if (idx >= n)
            return 0;
        
        if (memo[idx][ttype] != -1)
            return memo[idx][ttype];
        
        int v1 = 0;
        int v2 = 0;
        
        if (ttype == BUY)
        {
            v1 = - prices[idx] +rec(idx+1, SELL);
            v2 = rec(idx + 1, BUY);            
        }
        
        if (ttype == SELL)
        {
            v1 = prices[idx] + rec(idx + 2, BUY);
            v2 = rec(idx + 1, SELL);
        }
        
        memo[idx][ttype] = Math.max(v1, v2);
        
        return memo[idx][ttype] ;
        
    }
        
    
}