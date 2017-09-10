package problem189;

class Solution {
    public void rotate(int[] nums, int k) {
        
    	 
        int n = nums.length;
        int tmp[] = new int[n*2];
        int i = 0;
        k = k % n;
        
        if (k == 0)
        	return;
        
        for (i = 0; i < n; i++)
        {
        	tmp[i] = nums[i];
        	tmp[n+i] = nums[i];
        }
        
        if (k == 0)
        	k = 1;
        
        int z = 0;
        for (i = n - k; z < n; z++)
        {
        	nums[z] = tmp[i];
        	i++;
        }
        	
        
    }
    
    
}