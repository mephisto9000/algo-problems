package problem361;

class Solution {
    
    int left[][];
    int right[][];
    int up[][];
    int down[][];
    
    public int maxKilledEnemies(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;        
        
        int h = grid.length;
        int w = grid[0].length;        
        
        left = new int[h][w];
        right = new int[h][w];
        up = new int [h][w];
        down = new int [h][w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                if (i >= 1 )
                {
                    up[i][j] = up[i-1][j];
                }
                if (grid[i][j] == 'E')
                    up[i][j] += 1;
                if (grid[i][j] == 'W')
                    up[i][j] = 0;
            }
        
        for (int i = h-1; i >=0; i--)
           for (int j = 0; j < w; j++)
            {
                if (i < h-1 )
                {
                    down[i][j] = down[i+1][j];
                }
                if (grid[i][j] == 'E')
                    down[i][j] += 1;
                if (grid[i][j] == 'W')
                    down[i][j] = 0;
            }
        
        for (int j = 0; j < w; j++)
         for (int i = 0; i < h; i++)
            {
                if (j >=1 )
                {
                    left[i][j] = left[i][j-1];
                }
                if (grid[i][j] == 'E')
                    left[i][j] += 1;
                if (grid[i][j] == 'W')
                    left[i][j] = 0;
            }
        
        for (int j = w-1; j >= 0; j--)
         for (int i = 0; i < h; i++)
            {
                if (j < w - 1 )
                {
                    right[i][j] = right[i][j+1];
                }
                if (grid[i][j] == 'E')
                    right[i][j] += 1;
                if (grid[i][j] == 'W')
                    right[i][j] = 0;
            }
        
        int max = 0;
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                if (grid[i][j] == '0')
                {
                    int t = left[i][j]  + right[i][j] + up[i][j] + down[i][j];
                    
                    max = Math.max(max, t);
                }
            }
        
        return max;
        
        
        
    }
}