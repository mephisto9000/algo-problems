package problem325;

class Solution {   
    
    public int maxSubArrayLen(int[] nums, int k) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
         
        int rightSum[] = new int[n];
        int leftSum[] = new int[n];
        
        int totSum = 0;
                               
        for (int i = 0; i < n; i++)                  
            totSum += nums[i];          
                  
        for (int i = n-1; i>= 0; i--)
        {
            rightSum[i] = nums[i];
            if (i < n-1)
                rightSum[i] += rightSum[i+1];
        }
        
        for (int i = 0; i< n; i++)
        {
            leftSum[i] = nums[i];
            if (i > 0)
                leftSum[i] += leftSum[i-1];
        }
                                     
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
           for (int j = i; j < n; j++)
           {
               if ( rightSum[i] + leftSum[j] - totSum == k)
               {
                   int len = i > j ? i  - j : j - i;
                   len ++;
                   if (len > ans)
                       ans = len;
               }
           }                         
        }        
        return ans;                                        
    }
} 