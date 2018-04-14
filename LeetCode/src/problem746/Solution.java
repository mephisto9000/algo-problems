package problem746;

class Solution {
    int cost[];
    int n;
    int memo[];
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.n = cost.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return Math.min(rec(0), rec(1));
    }
    
    int rec(int idx) {
        if (idx >= n)
            return 0;
        
        if (memo[idx] > -1)
            return memo[idx];
        
        memo[idx] = Math.min(cost[idx] + rec(idx+1), cost[idx] + rec(idx + 2));
        return memo[idx];
        
    }
    
}