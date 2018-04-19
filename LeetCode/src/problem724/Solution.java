package problem724;

class Solution {
    public int pivotIndex(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return -1;
        int totSum = 0;
        
        for (int i = 0; i < nums.length; i++)
            totSum += nums[i];
        
        int tSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                tSum += nums[i-1];
            
            if (tSum == totSum - tSum - nums[i])
                return i;
        }
        return -1;
        
        
    }
}