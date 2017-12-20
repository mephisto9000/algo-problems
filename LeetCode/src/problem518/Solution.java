package problem518;

class Solution {
    int n;
    int coins[];
    int memo[][];
    
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.coins = coins;
        n = coins.length;
        memo = new int[501][5001];
        for (int i = 0; i <= 500; i++)
            Arrays.fill(memo[i], -1);       
        return rec(amount, 0);
        
    }
    
    int rec(int sum, int idx)
    {
        if (sum == 0)
        {            
            return 1;
        }
        if (sum < 0)
        {
            return 0;
        }
        if (idx >= n)
            return 0;
        
        if (memo[idx][sum] != -1)
            return memo[idx][sum];
        
        int ans = 0;
                 
        int cnt = 0;
        while (sum - coins[idx] * cnt >= 0)
        {
            ans += rec(sum - coins[idx] * cnt, idx+1);
            cnt ++;
        }
        
        memo[idx][sum] = ans;
        return ans;
    }
}