package problem162;

class Solution {
    public int findPeakElement(int[] nums) {
        
        //int idx = Integer.MIN_VALUE;
        
        if (nums == null || nums.length == 0)
            return -1; //idx;
        
        for (int i = 0; i < nums.length; i++)
        {
            boolean flag = true;
            if (i-1 > 0)
            {
                if (nums[i] < nums[i-1])
                    flag = false;
            }
            if (i + 1 < nums.length)
            {
                if (nums[i] < nums[i+1])
                    flag = false;
            }
            
            if (flag == true)
                return i;
        }
        
        return -1;
        
    }
}