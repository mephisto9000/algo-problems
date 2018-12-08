package problem941;

class Solution {
    public boolean validMountainArray(int[] A) {
        
        boolean asc = true;
        
        int i = 0; 
        int j = A.length-1;
        
        while(i < A.length-1 && A[i+1] > A[i])
            i++;
        while(j >0 && A[j-1] > A[j])
            j--;
        
        if (i == 0 || i == A.length-1 || j ==0 || j == A.length-1)
            return false;
        return (i==j);
        
    }
}