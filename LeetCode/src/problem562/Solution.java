package problem562;

class Solution {
    
    int dp[][][];
    int mtx[][];
    int h; 
    int w;
    int[][]dirs = {{0,1}, {1,-1}, {1,1}, {1,0}};
    
    public int longestLine(int[][] M) {
        
        if (M == null || M.length==0)
            return 0;
        
        h = M.length;
        w = M[0].length;
        mtx = M;
        dp = new int[h][w][4];
        int max = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
               for (int dir = 0; dir < 4; dir++)
            {                
                rec(i,j,dir);
                max = Math.max(max, dp[i][j][dir]);
            }
        return max;
        
    }
    
    int rec(int i, int j, int dir) {
        if (!isAccessible(i,j))
            return 0;
        
        if (dp[i][j][dir]!=0 || mtx[i][j]==0)
            return dp[i][j][dir];
                        
        dp[i][j][dir] = 1 + rec(i+dirs[dir][0], j+dirs[dir][1], dir);
        return dp[i][j][dir];
    }
    
    boolean isAccessible(int i, int j) {
        if (i < 0 || j < 0 || i >= h || j >= w)
            return false;
        return true;
    }
}