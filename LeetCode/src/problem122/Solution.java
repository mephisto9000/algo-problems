package problem122;

class Solution {
    public int maxProfit(int[] prices) {
                                
        if (prices==null || prices.length < 2)
            return 0;
        
        int lmin = 0;
        int lmax = 0;
        int n = prices.length;
        
        int UP = 1;
        int DOWN = -1;
        int mode = 0;
        int profit = 0;
        
        if (prices[1] - prices[0] > 0)
        {
            mode = UP;
            lmin = prices[0];
            lmax = prices[0];
        }
        else
        {
            mode = DOWN;
        }
        
        for (int i = 1; i < n; i++)
        {
            if (prices[i] - prices[i-1] > 0)
            {
               
                lmax = prices[i];
                
                mode = UP;
                
            }
            else
            {
                if (mode == UP)
                {
                    profit += lmax - lmin;
                    mode = DOWN;
                }
                
                lmin = prices[i];
                lmax = prices[i];
                
            }
            
            //System.out.println("i == "+i+" mode=="+mode +  " lmax=="+lmax+" lmin=="+lmin);
        }
        
        if (mode == UP)
        	profit += lmax - lmin;
        
        return profit;
        
    }
}