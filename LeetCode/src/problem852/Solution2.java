package problem852;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        
        int n = A.length;
        for (int i = 0; i < n; i++) {
            
            if ((i == 0 || A[i-1] < A[i]) && (i==n-1 || A[i] > A[i+1]))
                return i;
        }
        
        return -1;
            
    }
}