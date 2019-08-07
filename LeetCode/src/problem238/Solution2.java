package problem238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
       int multiLeft[] = new int[nums.length];
       int multiRight[] = new int[nums.length];
      
       for (int i = 0; i < nums.length; i++)
         multiLeft[i] = (i==0)?nums[i]:(nums[i]*multiLeft[i-1]);
      
      for (int i = nums.length-1; i >= 0; i--)
         multiRight[i] = (i==nums.length-1)?nums[i]:(nums[i]*multiRight[i+1]);
      
      int[] ans = new int[nums.length];
      
      for (int i = 0; i < nums.length; i++) {
        int v = 1;
        if (i > 0)
          v*= multiLeft[i-1];
        if (i < nums.length-1)
          v*=multiRight[i+1];
        ans[i] = v;
      }
      return ans;
    }
}