package problem645;

class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Arrays.sort(nums);
        
        int dup = Integer.MIN_VALUE;
        int miss = Integer.MIN_VALUE;
        
        Set<Integer> s = new HashSet();
        
        for (int i = 0; i<nums.length; i++)
        {
            if (i > 0)
                if (nums[i] == nums[i-1])
                    dup = nums[i-1];
            
            s.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length;i++)
        {
            if (!s.contains(i+1))
            {
                miss = i+1;
                break;
            }
        }       
        return new int[]{dup, miss};
    }
}