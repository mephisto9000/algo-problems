package problem766;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        for (int i = 1; i < h; i++)
            for (int j = 1; j < w; j++)
            {
                if (matrix[i-1][j-1] != matrix[i][j])
                    return false;
                    
            }
        
        return true;
        
    }
}