package problem163;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> ans = new LinkedList();
        
        StringBuffer sb = new StringBuffer();
        
        long lb = lower;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > lb)
            {                
                sb.setLength(0);
                sb.append(lb);
                if (nums[i]-1 > lb )//&& (i + 1)< nums.length)
                {
                    sb.append("->"+(nums[i]-1));
                }
                ans.add(sb.toString());                                
            }

            lb = (long) nums[i]+1;
            
        }
        
        if (lb <= upper)
        {
            if (lb == upper)
            {
                ans.add(String.valueOf(upper));                
            }
            else
            {
                sb.setLength(0);
                sb.append(lb+"->"+upper);
                ans.add(sb.toString());
            }
        }
        
        return ans;
    }
}