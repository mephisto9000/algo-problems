package problem41;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (nums[i]!=i+1 && nums[i] > 0)
            {
                
                int v = nums[i];;
                while(v>=1 && v <=n && v!=nums[v-1])
                {
                  int nv = nums[v-1];

                  nums[v-1] = v;
                  v = nv;
                  
                  
                }
            }
        }
        
    
        
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != i+1)
                return i+1;
        }
        
        return n+1;
        
    }
}
