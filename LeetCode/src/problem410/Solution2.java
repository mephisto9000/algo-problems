package problem410;

class Solution {
    public int splitArray(int[] nums, int m) {
      
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
      }
      
      long l = 0;
      long r = sum;
      
      long ans =  Integer.MAX_VALUE;
      while(l <= r) {
        long mid = (l + r) / 2;
        
        long locSum = 0;
        int cnt = 1;
        long largestSum = 0;
        for (int i = 0; i < nums.length; i++) {
          if (locSum + nums[i] <= mid)
            locSum += nums[i];
          else {
            cnt ++;
            largestSum  = Math.max(largestSum,  locSum);
            locSum = nums[i];
          }                        
        }
        
        largestSum  = Math.max(largestSum,  locSum);
        if (cnt == m)
          ans = Math.min(ans, largestSum); 
                
        if (cnt <= m) {
          r = mid - 1;
          }
        else {           
          l = mid + 1;
        }
          
      }
      
      return (int) ans;
        
    }
}