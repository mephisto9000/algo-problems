package problem188;

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if (k == 0||prices.length==0)
            return 0;
        
        if (k >= prices.length)
            k = prices.length;
        
        int buy[] = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int sell[] = new int[k];
        
        for (int price: prices) {
            for (int i = k-1; i >=0; i--) {                
                sell[i] = Math.max(sell[i], price - buy[i]);
                buy[i] = Math.min(buy[i], price- (i > 0 ? sell[i-1] : 0)); // - price);
            }
        }
        
        return sell[k-1];
        
    }
}