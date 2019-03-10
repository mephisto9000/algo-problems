package problem213;

class Solution {
    int memo[][];
    public int rob(int[] nums) {
      memo = new int[nums.length][2];
      
      for (int i = 0; i < nums.length; i++) {
        memo[i][0] = -1;
        memo[i][1] = -1;
      }
      
      return Math.max(rec(nums,0,0),
                      rec(nums,1,0)
                     );
    }
  
  int rec(int[] nums, int idx, int first) {
    
    if (idx >= nums.length)
      return 0;
    if (idx == nums.length-1) {
      return first==1 ? 0 : nums[idx];
    }
    
    if (memo[idx][first] != -1)
      return memo[idx][first];
    
    int ans = Math.max(nums[idx] + rec(nums, idx+2, (idx==0)?1:first),
                      rec(nums,idx+1, first));
    
    memo[idx][first] = ans;
    return ans;
    
  }
}