package problem300;

class Solution {
    
    int memo[][];
    int n;
    int nums[];
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;       
        
        if (nums.length == 1)
            return 1;
        
        if (nums.length == 2)
        {
            if (nums[1] > nums[0])
                return 2;
            else
                return 1;
        }
        
        this.nums = nums;
        n = nums.length;        
        memo = new int[n+1][n+1];
        
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                memo[i][j] = -1;
        
        return rec(0);// +1;        
    }
    int rec(int idx)
    {
        if (idx >= n)
            return 1;
        
        if (memo[idx][idx] > -1)
            return memo[idx][idx];
        int v1 = rec(idx + 1, idx);
        int v2 = rec(idx+1);
        
        memo[idx][idx] = Math.max(v1,v2);
        
        return memo[idx][idx];
    }
    
    int rec(int idx, int prevIdx)
    {
        if (idx >= n)
            return 1;
        
        if (memo[idx][prevIdx] > -1)
            return memo[idx][prevIdx];
        
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
         
        if (nums[idx] > nums[prevIdx])
               v1 = 1 + rec(idx + 1, idx);
    
            v2 = rec(idx+1, prevIdx);
 
        
        memo[idx][prevIdx] = Integer.max(Integer.max(v1,v2), v3);
        return memo[idx][prevIdx];        
    }
}