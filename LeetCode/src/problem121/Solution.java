package problem121;

class Solution {
	   public int maxProfit(int[] prices) {
			
			int min = Integer.MAX_VALUE;
			int minI = 0;
			int max = 0; 
				       
			for (int i = 0; i < prices.length; i++)
			{
	            if (prices[i] < prices[minI])
	                minI = i;
	            
	            if (prices[i] - prices[minI] > max)
	                max = prices[i] - prices[minI];
	            
			}
			
			return max;
		}
	}