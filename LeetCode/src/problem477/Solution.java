package problem477;

class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int dist = 0;
        for (int j = 0; j < 32; j++) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++)  {                              
               cnt += (nums[i] >> j) & 1;
            }
            dist += cnt * (nums.length-cnt);
                            
        }                                     
        return dist;
    }
    
     
}