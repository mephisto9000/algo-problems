package problem308;

class NumMatrix {
    
    int sums[][];
    int ftree[][];
    int w;
    int h;
    
    int mtx[][];
    
    public NumMatrix(int[][] matrix) {        
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        
        h = matrix.length;
        w = matrix[0].length;
        ftree = new int[h+1][w+1];
        mtx = matrix;
        sums = new int[h+1][w+1];
        
        for(int i = 1; i <= h; i++)
            for (int j = 1; j <= w; j++) {                
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i-1][j-1];
            }      
        
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                int r = i - (i & -i);
                int c = j - (j & -j);
                ftree[i][j] = sums[i][j] - sums[i][c] - sums[r][j] + sums[r][c];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int inc = val - mtx[row][col];
        mtx[row][col] = val;
        
        for (int i = row + 1; i <= h; i += (i & -i))
            for (int j = col + 1; j <= w; j += (j & -j))
                ftree[i][j] += inc;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) - getSum(row2+1, col1) - getSum(row1, col2+1) + getSum(row1, col1);
    }
    
    public int getSum(int r, int c) {
        int sum = 0;        
        for (int i = r; i > 0; i -= (i & -i)) {
            for (int j = c; j > 0; j -= (j & -j )) {
                sum += ftree[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */