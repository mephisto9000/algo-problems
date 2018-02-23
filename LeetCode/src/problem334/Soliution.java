package problem334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j<n; j++)
            {
                if (nums[i] < nums[j])
                    for (int k = j +1; k < n; k++)
                        if (nums[j] < nums[k])
                            return true;
            }
        
        return false;
    }
}