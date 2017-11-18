package problem213;

class Solution {
    
    int n;
    int nums[];
    
    int memoFT[];
    int memoFF[];
    
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        this.nums = nums;
        n = nums.length;
        
        memoFT = new int[n];
        memoFF = new int[n];
        
        Arrays.fill(memoFF, -1);
        Arrays.fill(memoFT, -1);
        
        return rec(0,false);
        
    }
    
    int rec(int idx, boolean firstTaken )
    {
        if (idx >= n)
            return 0;
        
        if (idx == n-1 && firstTaken)
            return 0;
        
        if (firstTaken)
        {
            if (memoFT[idx] != -1)
                return memoFT[idx];
        }
        else
        {
            if (memoFF[idx] != -1)
                return memoFF[idx];
        }
        
        
        int v1 = 0;
        if (idx == 0)
            v1 = nums[idx] + rec(idx+2, true);
        else
            v1 = nums[idx] + rec(idx+2, firstTaken);
        
        int v2 = rec(idx+1, firstTaken);
        
        int v = Math.max(v1,v2); 
        
        if (firstTaken)
            memoFT[idx] = v;
        else
            memoFF[idx] = v;
        
        return v;
        
    }
}