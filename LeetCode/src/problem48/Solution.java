package problem48;

class Solution {
    
    int n;    
    int mid;
    int[][] mtx;
    
    public void rotate(int[][] matrix) {
        
        if (matrix == null || matrix.length == 1)
            return;
        
        n = matrix.length;
        
        int mid =  (int) Math.ceil((float)n / 2.0);
        int mid2 = n % 2 > 0 ? mid - 1 : mid;
        mtx = matrix;
        
        
        System.out.println(mid);
        
        
        for (int i = 0; i < mid; i++)
        {
            for (int j = 0; j < mid2; j++)
            {
                rec(i, j, 0);                
            }
        }        
    }
    
    public void rec(int i, int j, int step)
    {
        if (step >= 4)
            return;

        int v = mtx[i][j];

        int ni = j;
        int nj = (n-1) - i;

        rec(ni, nj, step + 1);
        mtx[ni][nj] = v;
    }
    
    
}
