package problem733;

class Solution {
    int[][] image;
    boolean[][] visited;
    int h;
    int w;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        h = image.length;
        w = image[0].length;
        
        visited = new boolean[h][w];
        
        rec(sr, sc, image[sr][sc], newColor);
        return this.image;
    }
    
    void rec(int ii, int jj, int oldColor,  int newColor)
    {
        if (ii < 0 || ii >= h || jj < 0 || jj >= w || visited[ii][jj])
            return ;
        
        if (image[ii][jj] != oldColor)
            return;
        
        visited[ii][jj] = true;
        image[ii][jj] = newColor;
        
        rec(ii-1, jj, oldColor, newColor);
        rec(ii+1, jj, oldColor, newColor);
        rec(ii, jj-1, oldColor, newColor);
        rec(ii, jj+1, oldColor, newColor);
    }
}