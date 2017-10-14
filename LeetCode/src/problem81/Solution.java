package problem81;


class Solution {
    public boolean search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0)
            return false;
        
        int i = 0; 
        int j = nums.length - 1;
        
        Arrays.sort(nums);
        
        int oldM = -100000;
        while( i <= j)
        {
            int m = ( i + j ) / 2;
            
            if (oldM == m)
                break;
            oldM = m;
            
            if (nums[m] < target)
            {
                if (nums[j] >= target)
                    i = m;
                else
                    j = m;
                continue;
                
            }
            else
            if (nums[m] > target)
            {
                if (nums[i] <= target)
                    j = m;
                else
                    i = m;
                continue;
            }
            return true;


        }
        
        if (nums[i] == target || nums[j] == target)
            return true;
        else
            return false;
    }
}