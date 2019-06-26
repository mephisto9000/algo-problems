package problem329;

class Solution {
    
    int memo[][];
    int m,n;
    int mtx[][];
    public int longestIncreasingPath(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        mtx = matrix;
        int min = 0; 
        memo= new int[n][m];
        for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            memo[i][j] = -999;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                min = Math.max(min, rec(i,j,i,j));
        return min;
    }
    
    int rec(int i, int j, int pi, int pj) {
        if (!isValid(i,j))
            return 0;
        
        if ((i!=pi || j!= pj ) && mtx[pi][pj] >= mtx[i][j])
            return 0;
        
        if (memo[i][j]!=-999)
            return memo[i][j];
      
        int v = max4(rec(i-1,j,i,j), rec(i+1,j,i,j), rec(i,j-1,i,j), rec(i,j+1,i,j));
        
        memo[i][j] = v+1;
        return v+1;
        
    }
    
    int max4(int a, int b, int c, int d) {
        int m1 = Math.max(a, b);
        int m2 = Math.max(c, d);
        return Math.max(m1,m2);
        
    }
    
    boolean isValid(int i, int j) {
        if (i<0 || j< 0 || i >= n || j >= m)
            return false;
        return true;
    }
}