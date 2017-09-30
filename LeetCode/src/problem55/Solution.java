package problem55;

class Solution {
    public boolean canJump(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return true;
        
        int n = nums.length;
        int farest = 0;
        boolean reachable[] = new boolean[n];
        
        Arrays.fill(reachable, false);
        
        reachable[0] = true;
        for(int i = 0; i < n; i++)
        {
            if (!reachable[i])
                continue;
            
            int z = 1;
            if (i + nums[i] >= farest)                
                z = farest - i;
                    
            for (; z <= nums[i]; z++)
            {
             
                
                if (i + z < n)
                    reachable[i+z] = true;
                else
                    break;
            }
            
            if (i + nums[i] >= farest)
                farest = i + nums[i];
        }
        
        return reachable[n-1];
    }
}