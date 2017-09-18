package problem42;

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < min)
                min = nums[i];
            
            if (nums[i] > max)
                max = nums[i];
        }
        
        
    }
}