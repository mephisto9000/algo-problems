package problem311;

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int ans[][] = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int k = 0; k < A[0].length; k++) {
                
                if(A[i][k]!=0)
                for (int j =0; j < B[0].length; j ++) {
                    ans[i][j] += A[i][k]*B[k][j];                
                }
            }
        
        return ans;
        
    }
}