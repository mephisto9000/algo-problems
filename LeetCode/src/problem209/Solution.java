package problem209;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        
        int lsum = 0;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
        {       
            lsum = 0;
            for (int j = i; j < nums.length; j++)
            {
            lsum += nums[j];
            if (lsum >= s )
            {
                if (j - i +1 < min)
                {
                    min = j - i + 1;
                    break;
                }
                else
                {
                   break;
                }
            }
    
            }
            
            
        }
        
        if (min == Integer.MAX_VALUE)
            min = 0;
        
        return min;        
    }
}