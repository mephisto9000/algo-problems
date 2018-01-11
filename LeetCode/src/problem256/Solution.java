package problem256;

class Solution {
    
    int memo[][];
    int costs[][];
    
    int n;
    
    public int minCost(int[][] costs) {
        
        n = costs.length;
        
        this.costs = costs;
        memo = new int[n][3];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i] , -1);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++)
            min = Math.min(min, rec(0, i));
        
        return min;
    }
    
    int rec(int idx, int color)
    {
        if (idx >= n)
            return 0;        
        if (memo[idx][color] != -1)
            return memo[idx][color]; 
        int ans = Integer.MAX_VALUE;
        for (int i =0; i < 3; i++)
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