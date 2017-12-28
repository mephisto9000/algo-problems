package problem312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    int n; 
    int  memo[][];
    int nums[];
    
    public int maxCoins(int[] nums) {
       
    n = nums.length;	
    this.nums = nums;
    
    memo = new int[n][n];
    
    for (int i = 0; i < n; i++)
    	Arrays.fill(memo[i], -1);
    return rec( 0, n-1);
                
    }
    
        
    public int rec(int start, int end )
    {
    	
    	if (end < start)
    		return 0;
    	
    	if (memo[start][end]!=-1)
    		return memo[start][end];
    	
    	int max = 0;
        for (int i = start; i <= end; i++)
        {
        	int v = rec(start, i -1) + rec(i + 1, end) + getNum(start-1) * getNum(end +1) * getNum(i); 
        	if (v > max)
        		max = v;
        }
        
        memo[start][end] = max;
        
        return max;
    }
    
    int getNum(int idx)
    {
    	if (idx < 0 || idx >= n)
    		return 1;
    	
    	return nums[idx];
    }
    
    
}