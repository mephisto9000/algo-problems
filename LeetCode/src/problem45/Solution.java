package problem45;

import java.util.Arrays;

class Solution {
    int n;
    int[] nums;
    int memo[];
    public int jump(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        n = nums.length;
        this.nums = nums;
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        int ans = 0;
        for(int i = n-1; i>=0; i--)
        	ans =  rec(i);
        if (ans == 100000 )
            return 0 ;
        return ans;
    }
    
    int rec(int idx)
    {
        if (idx >= n-1)
            return 0; //100000;
        
        if (memo[idx]!= -1)
        	return memo[idx];
        
        int min = 1000000;
        for (int i = 1; i <= nums[idx]; i++)
        {
        	
            int v = 1 + rec(idx + i);
            if (v < min)
                min = v;
            if (i + idx > n)
            	break;
        }
        
        memo[idx] = min;
        return min;
    }
    
    
}