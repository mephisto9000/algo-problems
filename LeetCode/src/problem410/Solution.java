package problem410;

class Solution {
    int nums[];
    int m;
    Map<Integer, Long> memo;
    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        this.m = m;
        memo = new HashMap<>();
        return (int) rec(0, m);
    }
    
    long rec(int idx, int chunks) {
        if (idx >= nums.length)
            return Integer.MAX_VALUE;
        long sum = 0;
        if (chunks == 1) {
            for (int i = idx; i < nums.length; i++)
                sum+=nums[i];
            return sum;
        }
        int key = 117*idx + chunks;
        if (memo.containsKey(key))
            return memo.get(key);
        
        long ans = Integer.MAX_VALUE;
        for (int i = idx; i <nums.length; i++) {
            sum += nums[i];
            long next = rec(i+1, chunks-1);
            ans = Math.min(ans, Math.max(sum,next));                        
        }
        
        memo.put(key, ans);
        return ans;
        
        
    }
    
        
}