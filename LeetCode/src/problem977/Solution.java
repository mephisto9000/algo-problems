package problem977;

class Solution {
    public int[] sortedSquares(int[] A) {
        
        for (int i = 0; i < A.length; i++)
            if (A[i]<0)
                A[i] *= -1;
        
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++)
            A[i] = A[i]*A[i];
        
        return A;
    }
}