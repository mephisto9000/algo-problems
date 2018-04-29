package problem16;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE/2;
        for (int i = 0; i < nums.length-2; i++) {
            
            int l = i+1;
            int r = nums.length - 1;
        
            while(l < r) {
                int v = nums[i] + nums[l] + nums[r];
                
                if (v > target)
                    r--;
                else
                    l++;
                if (Math.abs(target - closest) > Math.abs(target - v))
                    closest = v;
            }
        }
        return closest;
        
    }
}