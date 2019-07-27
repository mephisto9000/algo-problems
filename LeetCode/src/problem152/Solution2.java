package problem152;

class Solution {
    public int maxProduct(int[] nums) {
      
       
       int start = 0;
      int end = 0;
      int max = Integer.MIN_VALUE;
    
       for (int i = 0; i < nums.length; i++) {
         if (nums[i] == 0) {
           max = max3(0, max, subSum(nums, start, end)); 
         }
         else {
           end = i;
           if (i>0 && nums[i-1]==0)
             start = i;
         }
         
       }
      
      max = Math.max(max, subSum(nums, start, end)); 
      return max;
    }
      
      int subSum(int[] nums, int l, int r) {
        if (l>=r)
          return nums[l];
        int rSum = 1;
        int max = 0;
        for (int i = l; i <= r; i++) {
          rSum *= nums[i];
        }
        int lSum = 1;

        for (int i = l; i <=r; i++) {
          lSum *= nums[i];
          rSum /= nums[i];
          max = max3(max, lSum, rSum);          
        }
        return max;
      }
      
      int max3(int a, int b, int c) {
        if (a > b)
          return Math.max(a,c);
        return Math.max(b, c);
      }
}