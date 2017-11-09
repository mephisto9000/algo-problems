package problem494;

class Solution {
    
    int count = 0;
    int n;
    int S;
    int nums[];
    
    
    public int findTargetSumWays(int[] nums, int S) {
        
        if (nums == null )
            return 0;
        
        this.S = S;
        n = nums.length;
        this.nums = nums;
        
        rec(0,0);
        return count;
    }
    
    void rec(int idx, int sum)
    {
        if (idx >= n)
        {
            if (sum == S)
                count ++;
            return;
        }
        
        rec(idx +1, sum + nums[idx]);
        rec(idx +1, sum - nums[idx]);
    }
    
}