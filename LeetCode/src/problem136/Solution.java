package problem136;

class Solution {
    public int singleNumber(int[] nums) {
        
        int v = 0;
        for (int i = 0; i < nums.length; i++)
            v = v ^ nums[i];
        
        return v;
        
    }
}