package problem322;

class Solution {
    int coins[];
    int memo[];
    public int coinChange(int[] coins, int amount) {
      
      Arrays.sort(coins);
      this.coins = coins;
      memo = new int[amount+1];
      Arrays.fill(memo, -2);
        
        
      return rec(amount);
        
    }
  
   int rec(int sum) {
     
     if (sum == 0)
       return 0; 
     
     if (sum < 0)
         return -1;
     
     if (memo[sum] != -2)
         return memo[sum];
       
     int ans = Integer.MAX_VALUE;  
     for (int i = coins.length-1; i >= 0; i--) {
         int rv = rec(sum-coins[i]);
         if (rv >= 0) {
             ans = Math.min(ans, rv+1);
         }
     }
     
     if (ans == Integer.MAX_VALUE)
         ans = -1;    
     memo[sum] = ans;
     return ans;
          
   }
}