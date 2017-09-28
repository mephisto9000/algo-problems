package problem80;

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        int prevCnt = 0;
        int cnt = 0;
        for (int i = 0; i <  n; i++)
        {
            if (prev != nums[i])
            {                
                prevCnt = 1;
                prev = nums[i];
                nums[cnt] = prev;
                cnt++;
            }
            else
            {
                prevCnt++;
                if (prevCnt == 2)
                {
                    nums[cnt] = prev;
                    cnt++;
                }
            }
        }
        
        return cnt;
            
            
        
    }
}