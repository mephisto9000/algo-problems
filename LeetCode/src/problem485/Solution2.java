package problem485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
      
      int lmax = 0;
      int gmax = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i]==1)
          lmax ++;
        else
          lmax = 0;
        
        gmax = Math.max(gmax, lmax);        
      }
      return gmax;
        
    }
}