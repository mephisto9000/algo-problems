package problem163;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        long missingLower;
        long missingUpper;
        List<String> sb = new LinkedList<>();
        
        
        if (nums == null || nums.length == 0) {
            if (lower==upper)
                sb.add(""+lower);
            else
                sb.add(lower+"->"+upper);
        }
        else {
        if (nums[0] > lower) {
            if (nums[0] - lower == 1)
                sb.add(""+lower);
            else
                sb.add(lower+"->"+((long) nums[0]-1));
        }
        
        for (int i = 1; i < nums.length; i++) {
            
            if ((long) nums[i] - (long) nums[i-1] > 1) {
                missingLower = (long)nums[i-1]+1;
                missingUpper = (long)nums[i]-1;
                if (missingLower == missingUpper)
                    sb.add(""+missingLower); 
                else {
                    sb.add(missingLower+"->"+missingUpper);
                }
            }   
            
        }
        
        if (nums[nums.length-1] < upper) {
            if (upper - nums[nums.length-1]  == 1)
                sb.add(""+upper);
            else
                sb.add(((long)nums[nums.length-1]+1)+"->"+upper);
        }
        }
                            
        return sb;
        
    }
}