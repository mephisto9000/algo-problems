package problem912;

class Solution {
    int len;
    int[] nums;
    public int[] sortArray(int[] nums) {
      this.nums = nums;
      return heapsort();
    }
  
    int[] heapsort() {
      len = nums.length;
      for (int i = len/2; i >= 0; i--)
        heapify(i);      
      
      while(len > 0) {
        swap(len-1, 0);
        len--;
        heapify(0);
      }
      return nums;
    }
  
   void swap(int idx1, int idx2) {
     int v = nums[idx1];
     nums[idx1] = nums[idx2];
     nums[idx2] = v;
   }
    void heapify(int idx) {
      if (idx >= len)
        return;

      int maxIdx = idx;
      int max = nums[idx];
      
      int newIdx = (idx*2) + 1;
      if (newIdx < len && nums[newIdx] > max) {        
        maxIdx = newIdx;
        max = nums[newIdx];
      }
      newIdx  = (idx*2) + 2;
      if (newIdx < len && nums[newIdx] > max) {        
        maxIdx = newIdx;
        max = nums[newIdx];
      }
      
      if (idx != maxIdx) {
        swap(idx, maxIdx);
        heapify(maxIdx);
      }
    }
}