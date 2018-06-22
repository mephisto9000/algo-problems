package problem698;


class Solution {
    int k;
    int nums[];
    int subsSize = 0;
    int buckets[];
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        for (int i = 0; i < nums.length; i++)
            subsSize += nums[i];
        if (subsSize % k > 0)
        	return false;
        subsSize /= k;
        buckets = new int[k];
        //Arrays.fill(buckets, subsSize);
        
        return rec(0);
        
        
        
    }
    
    boolean rec(int idx) {
        if (idx >= nums.length)
            return true;
        
        for (int i = 0; i < k; i++) {
            if (buckets[i] + nums[idx] <= subsSize) {
                
                buckets[i] += nums[idx];
                if (rec(idx+1))
                    return true;
                buckets[i] -= nums[idx];
            }
            if (buckets[i] == 0)
            	break;
        }
        return false;
    }
}