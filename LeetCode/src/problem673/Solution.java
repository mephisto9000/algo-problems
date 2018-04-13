package problem673;


class Solution {
    
    int nums[];
    int memo[];
    int paths[];
        
    public int findNumberOfLIS(int[] nums) {         
        this.nums = nums;
        memo = new int[nums.length];
        paths = new int[nums.length];        
        Arrays.fill(memo, -1);
        Arrays.fill(paths, -1);         
        int maxLis = 0;
        for (int i = 0; i < nums.length; i++)
        	maxLis =Math.max(maxLis, lis(i));                     
        int maxPaths = 0;            
        for (int i = 0; i < nums.length; i++)
        	if (memo[i] == maxLis)
        		maxPaths += paths[i];
        return maxPaths;
        
    }
    
    int lis(int idx )
    {
        int lmax = 1;
        int gmax = 1;
        if (idx == -1)
            return 0;                 
        if (memo[idx]!= -1)
            return memo[idx];        
        int cnt = 1;            
        for (int i = 0; i< idx; i++)
        {
            if (nums[idx] > nums[i])
            {
                
                lmax = 1 + lis(i);
                       
            if (lmax > gmax)
            {
                cnt = paths[i];
                gmax = lmax;
            }
            else
            if (lmax == gmax)  
                cnt += paths[i];
            }           
        }        
        paths[idx] = cnt;
        memo[idx] = gmax;                
        return gmax;
    }
}