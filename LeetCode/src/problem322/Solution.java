package problem322;

class Solution {
	
    int coins[];
    int amount;
 
    int memo[][];
    
    public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins);
        
        memo = new int[coins.length][amount+1];  
        
        for (int i = 0; i < coins.length; i++)
        	Arrays.fill(memo[i], -10);
        
        this.coins = new int[coins.length];
        int z = coins.length - 1;
        for (int i = 0; i < coins.length; i++)
        {
            this.coins[z] = coins[i];
            z--;
        }
        
        this.amount = amount;
        
        return  rec(0, amount);
    }
    
    int rec(int idx, int sum)
    {    	
        if (sum == 0)
            return 0;
        
        if (idx >= coins.length)
            return -1;
        
        if (memo[idx][sum] != -10)
        	return memo[idx][sum];
        
        int rem = sum; 
        int cnt = (int) Math.floor((float) rem/(float)coins[idx]);
       
        int min = Integer.MAX_VALUE;
        while (true)
        {
            int v = rec(idx + 1, sum - cnt*coins[idx]);
            
            if (v >= 0 && min > cnt + v)
            	min = cnt + v;

            cnt --;
            if (cnt < 0)
            	break;
        }

        if (min ==  Integer.MAX_VALUE)
        	min = -1;

		memo[idx][sum] = min;
        return min;                
    }   
}