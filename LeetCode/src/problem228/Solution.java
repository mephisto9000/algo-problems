package problem228;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return new LinkedList();
        
        int n = nums.length;
        int start = nums[0];
        int end = nums[0];
        // case with 1 element
        
        List<String> ans = new LinkedList();
        
        int i = 0;
        for (i = 1; i <= n; i++ )
        {
            int v;
            if (i == n)
                v = Integer.MAX_VALUE;
            else
                v = nums[i];
            
            if (v - end == 1)
            {
               end = v;
            }
            else
            {
                if (start < end)
                    ans.add(start+"->"+end);
                else
                    ans.add(""+end);
                    
                start = v;
                end = v;
                    
            }
        }        
        
        return ans;
    }
}