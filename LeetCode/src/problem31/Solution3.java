package problem31;

class Solution {
    public void nextPermutation(int[] nums) {
        
        boolean found = false;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                found = true;
                int farJ = i+1;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        farJ = j;
                    }
                }
                
                int t = nums[i];
                nums[i] = nums[farJ];
                nums[farJ] = t;
                
                int l = i+1;
                int r = nums.length-1;
                rotate(nums,l,r);
                break;
            }
        }
        
        if (!found) {
            rotate(nums, 0, nums.length-1);
        }
        
    }
    
    void rotate(int nums[], int l, int r) {
        while(l<r) {
                    int t = nums[l];
                    nums[l] = nums[r];
                    nums[r] = t;
                    l++;
                    r--;
                }
        
    }
}