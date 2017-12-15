package problem695;

class Solution {
    int w;
    int h;
    int mtx[][];
    boolean vis[][];
    public int maxAreaOfIsland(int[][] grid) {
        
        mtx = grid;
        if (mtx == null || mtx.length == 0 || mtx[0].length == 0)
            return 0;
        
        int max = 0;
        h = mtx.length;
        w = mtx[0].length;
        vis = new boolean[h][w];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                int lmax =  rec(i,j);
                if (lmax > max)
                    max = lmax;
            }
        return max;
    }
    
    int rec(int i, int j)
    {
        if (!isOk(i,j))
            return 0;
        int ans = 1;
        ans += rec(i-1,j);
        ans += rec(i+1,j);
        ans += rec(i,j-1);
        ans += rec(i,j+1);
        return ans;
    }
    
    boolean isOk(int i, int j)
    {
        if (i >=0 && i < h && j >= 0 && j < w && mtx[i][j]==1 && vis[i][j]==false)
        {
            vis[i][j] = true;
            return true;
        }
        return false;
    }
}