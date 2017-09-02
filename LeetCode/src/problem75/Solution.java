package problem75;

class Solution {
    public void sortColors(int[] nums) {
        
        int a[] = new int[3];
        
        for (int i = 0; i < nums.length; i++)
        {
            int v = nums[i];
            a[v] ++;
        }
        
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (a[idx]>0)
            {
                nums[i] = idx;
                a[idx] --;
            }
            else
            {
                while(a[idx] == 0)
                    idx ++;
                
                nums[i] = idx;
                a[idx] --;
            }
            
        }
        
    }
}