package problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        
        if (n < 1)
            return 0;
        
        
        int curr_max = nums[0];
        
        int g_max = nums[0];
        
        for (int i = 1; i < n; i++)
        {
            if (curr_max < 0)
                curr_max = nums[i];
            else
                curr_max += nums[i];
            
            if (g_max < curr_max)
                g_max = curr_max;
        }
        
        return g_max;
        
    }
}
