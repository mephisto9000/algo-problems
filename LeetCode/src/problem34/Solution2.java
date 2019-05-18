package problem34;

class Solution {
    int nums[];
    
    public int[] searchRange(int[] nums, int target) {
        
        if (nums==null || nums.length == 0 )
            return new int[] {-1,-1};
        this.nums = nums;
        int l = binSearch(target);
        while(l > 0  && nums[l-1] == target)
            l--;
        
        if (l < 0 || l >= nums.length)
            return new int[]{-1,-1};
        if (nums[l] == target) {
            int r = binSearch(target+1);
            while(r >= nums.length || nums[r]!=target)
                r--;
            return new int[] {l,r};
        }
        else
        return new int[] {-1,-1};
        
      
        
    }
    
    int binSearch(int target) {
        int l = 0;
        int r = nums.length-1;
          
        while(l <= r) {
            int m = (int) ((long)l+r)/2;
            
            if (nums[m]==target) {
                return m;
            }
            if (nums[m] < target)
                l = m+1;
            else
                r = m-1;
            
        }
        return l;
    }
}