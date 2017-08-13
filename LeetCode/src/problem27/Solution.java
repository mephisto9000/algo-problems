package problem27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        
        int n = nums.length;
        int len = 0;
        
        int a = 0; //start from el 
      
            
        
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != val)
            {
                len++;
               
                nums[a] = nums[i];   
                a++;
            }
        }
        
        return len;
        
        
    }
}