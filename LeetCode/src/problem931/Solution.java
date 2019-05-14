package problem931;

class Solution {
    
    int w;
    int h;
    int memo[][];
    int [][]A;
    public int minFallingPathSum(int[][] A) {
        
        w = A.length;
        h = A[0].length;
        memo = new int[h][w];
        this.A = A;
                        
        for (int i = 0; i < h; i++)
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        
        for (int i = h-1; i >= 0; i--)
            for (int j = 0; j < w; j++)
                rec(i, j);
        
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < w; j++)
            ans = Math.min(ans, memo[0][j]);
        
        return ans;
    }
    
    void rec(int i, int j) {
        int v = A[i][j] += min3(getVal(i+1,j), getVal(i+1, j+1), getVal(i+1, j-1));
        
        memo[i][j] = v;
                
    }
    
    int getVal(int i, int j) {
        if (i >= h)
            return 0;
        if (j < 0 || j >= w)
            return Integer.MAX_VALUE;
        return A[i][j];
    }
    
    int min3(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else
            return Math.min(b,c);
    }
    
    
}