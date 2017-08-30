package problem33;

public class Solution {
	
	    public int search(int[] nums, int target) {
	        
	    int i = 0;
	    int j = nums.length - 1;
	        
	    while(i < j)
	    {
	        int old_i = i;
	        int old_j = j;
	        int m = (i + j) / 2;
	        
	        if (nums[m] > target)
	        {

	            if (target >= nums[i] || nums[m] <= nums[j])
	            {
	                j = m;
	                if (j == old_j)
	                  j--;
	            }
	            else
	            {
	                i = m;
	                if (i == old_i)
	                    i++; 
	            }
	        }
	        else
	        if (nums[m] < target)
	        {

	        	if (nums[j] >= target || nums[i] <= nums[m]) 
	            {
	              i = m;        
	              if (i == old_i)
	                i++;
	            }
	            else
	            {
	                  j = m;
	                if (j == old_j)
	                  j--;
	            }
	        }
	        else
	            return m;
	    }
	        
	    if (nums.length > i && nums[i]==target)    
	        return i;
	        else
	        return -1;
	        
	        
	        
	    }
	    
	    
	

}
