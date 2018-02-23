package problem674;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
            
        int max = 1;
        int local = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > nums[i-1])
                local ++;
            else
                local = 1;
            
            if (local > max)
                max = local;
        }
        
        return max;
        
    }
}