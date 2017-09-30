package problem198;

class Solution {
    int nums[];
    int n;
    
    int memo[];
    
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        
        this.nums = nums;
        n = nums.length;
        
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        return rec(0);
        
    }
    
    int rec(int idx )
    {
        if (idx >= n)
            return 0;
        
        if (memo[idx]!=-1)
            return memo[idx];
        
        int v1 = nums[idx] + rec(idx + 2);
        int v2 = rec(idx + 1);
        
        memo[idx] =  v1 > v2 ? v1 : v2;
        
        return memo[idx];
    }
}