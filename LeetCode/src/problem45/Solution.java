package problem45;

import java.util.Arrays;

class Solution {
	  public int jump(int[] nums) {
			
	        if (nums == null || nums.length == 0)
	            return 0;
	        
	        int n = nums.length;
	        
	        int steps = 0;
	        int maxDist = nums[0];
	        int currentDist = 0;
	        for (int i = 1; i < n; i++)
	        {
	        	
	        	
	        	if (currentDist < i)
	        	{
	        		steps ++;
	        		currentDist = maxDist; // = i;
	        	}
	        	
	        	maxDist = (maxDist > i + nums[i] ? maxDist : i + nums[i]);
	        	
	        	//if (maxDist >= n-1)
	        	//	return steps;
	        	
	        }
	        return steps;
	        
		
		}
	}
    
}