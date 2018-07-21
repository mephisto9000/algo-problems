package problem714;

class Solution {
    
    int prices[];
    int fee;
    
    int buyMemo[];
    int sellMemo[];
    
    public int maxProfit(int[] prices, int fee) {
        
        this.prices = prices;
        this.fee = fee;
        
        buyMemo = new int[prices.length];
        sellMemo = new int[prices.length];
        
        Arrays.fill(buyMemo, Integer.MIN_VALUE);
        Arrays.fill(sellMemo, Integer.MIN_VALUE);
        
        return buy(0);        
    }
    
    int buy(int idx) {
        
        if (idx >= prices.length)
            return 0;
        
        if (buyMemo[idx] > Integer.MIN_VALUE)
            return buyMemo[idx];
        
        int ans = Math.max(buy(idx + 1), -prices[idx] - fee + sell(idx + 1));
        buyMemo[idx] = ans;
        return ans;
    }
    
    int sell(int idx) {
        if (idx >= prices.length) 
            return 0;
        
        if (sellMemo[idx] > Integer.MIN_VALUE)
            return sellMemo[idx];
        int ans = Math.max(prices[idx] + buy(idx+1), sell(idx+1));
        sellMemo[idx] = ans;
        return ans;
    }
}