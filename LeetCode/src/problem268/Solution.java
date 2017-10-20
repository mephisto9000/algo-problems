package problem268;

class Solution {
    public int missingNumber(int[] nums) {
        
        if (nums == null || nums.length < 1)
            return 0;
        
        int totR = 0;
        
        for (int i = 1; i <= nums.length; i++)
            totR += i;
        
        int tot = 0;
        for (int i = 0; i < nums.length; i++)
        {
            tot += nums[i];
        }
        
        return totR - tot;
        
    }
}