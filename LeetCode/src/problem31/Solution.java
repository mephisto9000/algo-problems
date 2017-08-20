package problem31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        
        boolean found = false;
        
        if (  nums.length <=1 )
            return ;
        
        
        for (int i = nums.length - 2; i>= 0; i--)
        {
            if (nums[i] < nums[i+1])
            {
                int max_j = - 1;
                for (int j = i+1; j < nums.length; j++)
                {
                    if (nums[j] > nums[i])
                        max_j = j;
                }
                
                //swap
                int v = nums[i];
                nums[i] = nums[max_j];
                nums[max_j] = v;
                
                int tmp[] = new int[nums.length - i];
                int z = 0;
                
                for (int j = i+1; j < nums.length; j++)
                {
                    tmp[z] = nums[j];
                    z++;
                }
                
                for (int j = i+1; j < nums.length; j++)
                {
                    z--;
                    nums[j] = tmp[z];
                }
                
              found = true;  
              break;
            }
        }
        
        if (!found)
            Arrays.sort(nums);
        
    }
}