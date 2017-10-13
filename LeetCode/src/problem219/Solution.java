package problem219;

class Solution {
    
    Set<Integer> hs; 
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if (nums == null || nums.length == 0)
            return false;
        
        hs = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length;  i++)
        {            
           
            
            if (hs.contains(nums[i]))
            {
                return true;
            }
                
            hs.add(nums[i]);
            
            if (i >= k)
            {
                hs.remove(nums[i - k]);
            }
            
 
        }
        
        return false;
        
    }
}