package problem463;

class Solution {
    
    int grid[][];        
    int w;
    int h;
    
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        h = grid.length;
        w = grid[0].length;
        int ans = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                ans += calc(i, j);
            }
        
        return ans;
    }
    
    int calc(int i, int j)
    {
        if (grid[i][j] == 0)
            return 0;
        
        int sum = 0;
        
        if (i == 0 || grid[i-1][j] == 0)
            sum += 1;
        if (j == 0 || grid[i][j-1] == 0)
            sum += 1;
        if (i == h-1 || grid[i+1][j] == 0)
            sum +=1;
        if (j == w-1 || grid[i][j+1] == 0)
            sum += 1;
        
        
         return sum;               
    }
}