package problem845;

class Solution {
    int[] A;
    int maxLen = 0;
    int uphilLen = 0;
    int downhilLen = 0;
    
    public void check() {
        if (downhilLen == 0 || uphilLen == 0) 
            return;
        maxLen = Math.max(maxLen, uphilLen + downhilLen);                
        uphilLen = 0;
        downhilLen = 0;
    }
    
    public int longestMountain(int[] A) {
        if (A.length < 3)
            return 0;
        this.A = A;
                                       
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) { // uphill 
                check();
                uphilLen += uphilLen ==0 ? 2: 1;                
            } else 
            if (A[i] < A[i-1] && uphilLen > 0) { // uphill                 
                downhilLen++;
            } else
            {
                check();
                uphilLen = 0;
                downhilLen = 0;
            }                
        }
        check();        
        return maxLen;        
    }
}