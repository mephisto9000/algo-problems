package problem121;

class Solution {
    public int maxProfit(int[] prices) {
      
      int n = prices.length;
      int maxRight[] = new int[n];
      int max = 0;
      for (int i = n-1; i >= 0; i--) {
        maxRight[i] = Math.max(max, prices[i]);
        max = maxRight[i];
      }
      
       max = 0;
      for (int i = 0; i < n; i++) {
        max = Math.max(maxRight[i]-prices[i], max);
      }
      
      return max;
        
    }
}