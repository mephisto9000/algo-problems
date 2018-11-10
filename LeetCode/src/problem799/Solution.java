package problem799;

class Solution {
    
    double mtx[][];
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        mtx = new double[100][100];
        pour2(poured, 0, 0);
        
        return (mtx[query_row][query_glass]);
    }
    
    void pour2(double water, int ii, int jj) {
        
        mtx[ii][jj] = water;
        for (int i = 0; i < 100; i++)
            
            for (int j = 0; j <= i; j++)
                if (mtx[i][j] > 1) {
                    
                    double rem = mtx[i][j]-1;
                    mtx[i][j] = 1;
                    double rem2 = rem/2;
                    
                    if (i+1 < 100 ) {
                        mtx[i+1][j] += rem2;                        
                        mtx[i+1][j+1] += rem2;
                        }                    
                }
    }
    
    void pour(double water, int i, int j) {
                
        if (i >= 100 || j > i)
            return;
        
        double rem = water - (1 - mtx[i][j]);
        
        if (rem > 0) {
            mtx[i][j] = mtx[i][j] + water - rem;
            double rem2 = rem/2;
            pour(rem2, i+1, j);
            pour(rem2, i+1, j+1);
        }
        else
            mtx[i][j] += water;
            
    }
}