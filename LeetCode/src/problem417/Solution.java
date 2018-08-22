package problem417;

class Solution {
    int grid[][];
    boolean visited[][];
    int h;
    int w;
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new LinkedList();
        
        if (matrix == null || matrix.length == 0)
            return ans;
        
        
        grid = matrix;
        h = grid.length;
        w = grid[0].length;
        for (int i =0; i < h; i++)
            for (int j = 0; j < w; j++) {
                if (rec(i,j,i,j) == 3)
                    ans.add(new int[]{i,j});
            }
        
        return ans;
        
    }
    
    int rec(int i, int j, int pi, int pj) {
        if (i < 0 || j < 0 || i >= h || j >= w)
            return 0;
        
        if (grid[i][j]> grid[pi][pj])
            return 0;
        
        if (i==pi && j == pj)
            visited = new boolean[h][w];
        
        
        if (visited[i][j])
            return 0;
        
        visited[i][j] = true;
                
        int v = 0;
        if (i == 0 || j == 0)
            v = 1;
        if (i == h-1 || j == w -1)
            v |= 2;
        v |= rec(i-1,j,i,j);
        v |= rec(i+1,j,i,j);
        v |= rec(i, j-1,i,j);
        v |= rec(i, j+1,i,j);
        
        return v;
            
        
    }
}