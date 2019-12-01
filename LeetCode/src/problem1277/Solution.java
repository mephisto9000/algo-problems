package problem1277;

class Solution {
    int h;
    int w;
    int sums[][];
    int mtx[][];
    public int countSquares(int[][] matrix) {
        
        h = matrix.length;
        w = matrix[0].length;
        sums = new int[h][w];
        mtx = matrix;
        
        
        for (int i = h-1; i >=0; i--) {
            int layerSum = 0;
            for (int j = w-1; j >=0; j--) {
                
                layerSum +=  matrix[i][j];
                sums[i][j] = layerSum;
                if( i < h-1) {
                    sums[i][j] += sums[i+1][j];
                }                
            }
        }
        
        int ans = 0;
        for (int i = 0; i < h; i++) {        
            for (int j = 0; j < w; j++) {
                int off = 0;
                while(isValid(i+off, j+off)) {
                    if (Math.pow(off+1, 2) == getSum(i,j,i+off+1, j+off+1)) {
                        ans ++;
                    }
                    off ++;
                }
            }
        }
        
        return ans;
        
    }
    
    int getSum(int i1, int j1, int i2, int j2) {
        int v = sums[i1][j1];
        
        if(i1==i2 && j1 == j2) {
            return mtx[i1][j1];
        }
        
        if (isValid(i1,j2)) {
            v -= sums[i1][j2];
        }
        
        if (isValid(i2,j1)) {
            v -= sums[i2][j1];
        }
        
        if (isValid(i2,j2)) {
            v += sums[i2][j2];
        }
        
        return v;
    }
    
    boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= h || j >= w) {
            return false;
        }
        return true;
    }
}