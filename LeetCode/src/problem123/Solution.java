
package problem123;

class Solution {
    
    int sStart = 0;
    int sEnd = -1; 
    
    public int maxProfit(int[] prices) {

        if (prices==null || prices.length < 2)
            return 0;

        sEnd = prices.length - 1;
        
        int n = prices.length;
        int max = 0;
        /*
        for (int i = 0; i < n; i++)
        {
        	int ans = calcProfit(prices, i,  0);
                        
            
            ans += calcProfit(prices, n , i);
            
            if (ans > max)
            	max = ans;
            	
        } */
        
        max = calcProfit(prices, n,  0);
        
         
        return max;
    }


    public int calcProfit(int prices[], int maxAllowedIdx, int minAllowedIdx)
    {
        int minSum = 0;
        int minIdx = 0;

        int localMinIdx = minAllowedIdx; 
        int localSum = 0;
        
        int prevMax = 0;
                
        for (int i = minAllowedIdx + 1; i< maxAllowedIdx ; i++)    	        
        {        	
        	if (i >= prices.length)
        		break;
        	        	
            localSum = prices[i] - prices[localMinIdx];

            if (localSum < minSum)
            {                                              
                //sStart = i;
                localMinIdx = i;
                
                prevMax = minSum;

            }

            if (minSum < localSum )
            {                 
            	sStart = localMinIdx;
                sEnd = i;
                minSum = localSum;
            }
        }
        
        return minSum + prevMax;
    }
}