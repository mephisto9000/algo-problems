package problem852;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length; i++) {            
            boolean l = true;            
            if (i==0 || A[i-1] >= A[i])
                l = false;                           
            boolean r = true;
            if (i==A.length-1 || A[i+1] >= A[i])
                r = false;
            
            if (l&&r)
                return i;                
                
            
        }
        
        return -1;
        
    }
}