package problem31;

class Solution {
    public void nextPermutation(int[] nums) {
      
      boolean found = false;
      for (int i = nums.length-1; i >= 1; i--) {
        
        if (nums[i] > nums[i-1]) {          
          int max_idx = i;
          for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i-1])
              max_idx = j;
          }
          
          swap(nums, i-1, max_idx);
          reorder(nums,i, nums.length-1);
          found = true;
          break;
        }
        
      }
      if (!found)
        Arrays.sort(nums);
     
    }
  
  void swap(int nums[], int i, int j) {
    int t = nums[j];
    nums[j] = nums[i];
    nums[i] = t;
  }
  
  void reorder(int nums[], int l, int j) {
    while(l < j) {
      swap(nums,l++, j--);
    }
  }
}