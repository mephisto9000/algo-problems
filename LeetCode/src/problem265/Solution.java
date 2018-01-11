package problem265;

class Solution {
    
    int memo[][];
    int costs[][];
    
    int n;
    int k;
    
    public int minCostII(int[][] costs) {
        
        if (costs == null || costs.length == 0 || costs[0].length  == 0)
            return 0;
        
        n = costs.length;
        
        
        k = costs[0].length;
        
        
        
        this.costs = costs;
        memo = new int[n][k];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i] , -1);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++)
            min = Math.min(min, rec(0, i));
        
        return min;
    }
    
    int rec(int idx, int color)
    {
        if (idx >= n)
            return 0;
        
        if (idx == n-1)
            return costs[idx][color];
        
        
        if (memo[idx][color] != -1)
            return memo[idx][color]; 
        int ans = Integer.MAX_VALUE;
        for (int i =0; i < k; i++)
        {
            int v;
            if (i == color)
                v = Integer.MAX_VALUE;
            else
                v = costs[idx][color] + rec(idx + 1, i);
            
            ans = Math.min(ans, v);
        }
        
        memo[idx][color] = ans;
        return ans;        
    }
}