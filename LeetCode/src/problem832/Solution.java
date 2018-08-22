package problem832;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int[][]ans = new int[A.length][A[0].length];
        
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                ans[i][A[0].length-1 - j] = A[i][j] == 0?1:0;
        
        return ans;
        
    }
}