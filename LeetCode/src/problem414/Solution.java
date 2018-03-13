package problem414;

class Solution {
    public int thirdMax(int[] nums) {
        
        Integer max[] = new Integer[3];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int cache = Integer.MIN_VALUE;
            if (max[0] == null || nums[i] > max[0])
            {
                //cache = max[0];
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nums[i];                                
            }
            else
            if (max[1] == null || nums[i] > max[1])
            {
                max[2] = max[1];
                max[1] = nums[i];
            }
            else
            if(max[2] == null || nums[i] > max[2])
                max[2] = nums[i];
        }
        
        if (max[2] == null)
            return max[0];
        
        return max[2];
        
    }
}