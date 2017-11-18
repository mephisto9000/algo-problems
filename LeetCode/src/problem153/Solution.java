package problem153;


class Solution {
    public int findMin(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        int i = 0;
        int j = nums.length-1;
        int oldM = -1000;
        
        while(i <= j)
        {
            int m = (i + j)/2;
            
            if (m == oldM)
                break;
            
            oldM = m;
            
            if (nums[i] > nums[j])
            {
                if (nums[i] < nums[m])
                    i = m;
                else
                    j = m;
                //if (nums[m] >)
            }
            else
            {
                if (nums[i] < nums[m])
                    j = m;
                else
                    i = m;
            }
        }
        
        if (i +1 < nums.length)
        {
        	if (nums[i+1] < nums[i])
        		i++;
        }
        else
        if (i-1 >= 0)
        {
          	if (nums[i-1] < nums[i])
          		i--;
        }
        	
        return nums[i];
        
    }
}