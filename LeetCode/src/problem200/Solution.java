package problem200;

class Solution {
    
    boolean visited[][];
    char grid[][];
    int w;
    int h;
    
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0)        
            return 0;
        
        this.grid = grid;
            
        h = grid.length;
        w = grid[0].length;
        
        visited = new boolean[h][w];
        for (int i = 0; i < h; i++)
            Arrays.fill(visited[i], false);
        
        int cnt=0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                cnt += rec(i,j);
        
        return cnt;
        
        
    }
    
    int rec(int i, int j)
    {
        if (i < 0 || i >= h || j < 0 || j >= w || visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        if (grid[i][j]=='0')
            return 0;
        
        rec(i -1, j);
        rec(i +1, j);
        rec(i , j -1);
        rec(i , j +1);
            
        return 1;    
    }
}