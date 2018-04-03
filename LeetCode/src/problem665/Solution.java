package problem665;

class Solution {
    public boolean checkPossibility(int[] nums) {
        
        if (nums == null || nums.length < 3)
            return true;
        
        int cnt = 0;
        
        int[] nnums = new int[nums.length+2];
        
        nnums[0] = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
            nnums[i+1] = nums[i];
        
        nnums[nnums.length - 1] = Integer.MAX_VALUE;
        
        
        for (int i = 1; i < nnums.length-1; i++)
        {
            if (nnums[i] < nnums[i - 1])
            {
                 
                if (i == 2 || nnums[i-2] <= nnums[i] || nnums[i-1] <= nnums[i+1])
                   cnt++;
                else
                    return false;
            }
        }
        if (cnt > 1)
            return false;
            
        return true;
        
    }
}