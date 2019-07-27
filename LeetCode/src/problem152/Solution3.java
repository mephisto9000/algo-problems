package problem152;

class Solution {
    public int maxProduct(int[] nums) {
      
      int min = nums[0];
      int max = nums[0];
      int ans = nums[0];
                  
      for (int i = 1; i<nums.length; i++) {
        
        if (nums[i] > 0) {
          max = Math.max(max * nums[i], nums[i]) ;
          min = Math.min(min * nums[i], nums[i]);
        } else
        if (nums[i] == 0) {
          max = 0;
          min =0;
        } else // neg          
        {
          int tmp = min;
          min = Math.min(max*nums[i], nums[i]);
          max = Math.max(tmp * nums[i], nums[i]);
        }        
        ans = Math.max(ans, max);        
      }
      return ans;
        
    }
}