package problem283;

class Solution {
    public void moveZeroes(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return;
        
        int zc = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
                zc ++;
        }
        
        int ofs = 0;
        
        for (int i = 0; i < nums.length - zc; i++)
        {
            //if (z)
            while(nums[i + ofs] == 0)
                ofs ++;
            
            if (ofs > 0) // swap
            {
                nums[i] = nums[i + ofs];
            }
        }
        for (int i = nums.length - zc ; i < nums.length; i++)
            nums[i] = 0;
        
        
        
    }
}