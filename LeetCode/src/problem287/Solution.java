package problem287;

class Solution {
    public int findDuplicate(int[] nums) {
        
        int i = nums[0];
        int j = nums[0];
        int n = nums.length;
        
        // p1
        while (true)
        {
            i = nums[nums[i]];
            j = nums[j];
            if (i == j)
            {            
            	break;
            }
        }
        
        //j = nums[j]; 
        i = nums[0];
 
        while(i!=j)
        {
        	
        	i = nums[i];
        	j = nums[j];
        }
        
        
        return i;
        
    }
}