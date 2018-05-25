package problem485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int startPos = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                max = Math.max(max, i - startPos);
            else
                startPos = i;
        }
        
        return max;
            
        
    }
}