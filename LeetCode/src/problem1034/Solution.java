package problem1034;

class Solution {
    int nums[][];
    boolean visited[][];
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        this.nums = grid;
        visited = new boolean[grid.length][grid[0].length];
        
        rec(r0,c0,nums[r0][c0], color);
        return grid;
        
    }
    
    void rec(int i, int j, int component, int color) {
        if (!isValid(i,j) || visited[i][j] || nums[i][j]!=component)
            return;
        
        boolean paint = false;
        if (isBoundary(i,j,component))
            paint = true;
        
        
        visited[i][j] = true;
        
        //nums[i][j] = color;
        rec(i-1, j, component, color);        
        rec(i+1, j, component, color);
        rec(i, j-1, component, color);
        rec(i, j+1, component, color);
        
        if (paint)
            nums[i][j] = color;
        
    }
    
    boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= nums.length || j >= nums[0].length)
            return false;
        return true;
    }
    
    boolean isBoundary(int i, int j, int gridColor) {
        if (i==0 || j == 0 || i ==nums.length-1 || j == nums[0].length-1) 
            return true;
        if (isValid(i-1,j) && nums[i-1][j]!=gridColor)
            return true;
        if (isValid(i,j-1) && nums[i][j-1]!=gridColor)
            return true;
        if (isValid(i+1,j) && nums[i+1][j]!=gridColor)
            return true;
        if (isValid(i,j+1) && nums[i][j+1]!=gridColor)
            return true;
        return false;
    }
}