package problem376;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int nums[];
    int memo[][][];           
    public int wiggleMaxLength(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n][n][2];
        return Math.max(rec(0, 0, 0), rec(0,1, 0));
    }
    
    int rec(int idx, int asc, int lastIdx) {
        
        if (nums.length <= idx  )
            return 0;
        
        
        if (memo[lastIdx][idx][asc]> 1)
            return memo[lastIdx][idx][asc]-1;
        
        int ans = 0;
        if (asc==1 ) {
            if (nums[idx] > nums[lastIdx] || idx == 0)
                ans = Math.max(1 + rec(idx+1, 1-asc, idx), rec(idx+1, asc, lastIdx));
            else
                ans= rec(idx+1, asc, lastIdx);
            }
        else {
            //desc
            if (nums[idx] < nums[lastIdx] || idx == 0)
                ans =  Math.max(1 + rec(idx+1, 1-asc, idx), rec(idx+1, asc, lastIdx));
            else
                ans =  rec(idx+1, asc, lastIdx);
        }
        
        memo[lastIdx][idx][asc] = ans+1;
        return ans;
    }
}