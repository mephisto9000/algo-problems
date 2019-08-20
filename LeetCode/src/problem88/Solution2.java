package problem88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {        
        int i = nums1.length-1;
        
        int arrIdx1 = m-1;
        int arrIdx2 = n-1;
        while(arrIdx1 >=0 && arrIdx2 >= 0) {                       
            if (nums1[arrIdx1] >= nums2[arrIdx2]) {
                nums1[i--] = nums1[arrIdx1--];
            } else {
                nums1[i--] = nums2[arrIdx2--];
            }            
        }
        
        while(arrIdx1 >= 0) {
            nums1[i--] = nums1[arrIdx1--];
        }
        
        while(arrIdx2 >= 0) {
            nums1[i--] = nums2[arrIdx2--];
        }                       
    }
}