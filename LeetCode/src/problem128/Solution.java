package problem128;

class Solution {
    
    int nums[];
    Map<Integer, Integer> ids;
    int [] memo;
    
    public int longestConsecutive(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        this.nums = nums;
        int n = nums.length;
        memo = new int[n];
        
        Arrays.fill(memo, -1);
                
        ids = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
        {
             
            
            ids.put(nums[i], i);
        }
        
        
        int max = 0;
        int localMax = 0;
        
        int z = 0;
        for (int i = 0; i < n; i++)
        {            
            z = i;
            localMax = 0;
                         
            if (memo[z]>= 0)
                localMax = memo[z];
            else
                localMax = rec(z);
             
            
            if (localMax > max)
                max = localMax;
            
        }
        
        return max;
                            
    }
    
    public int rec(int idx)
    {
        if (memo[idx] > -1)
            return memo[idx];
        
        
        int v = nums[idx];  
        if (ids.containsKey(v + 1))     
        {
            memo[idx] = 1 + rec(ids.get(v + 1));
        }
        else
            memo[idx] = 1;
        
        return memo[idx];
         
    }
}