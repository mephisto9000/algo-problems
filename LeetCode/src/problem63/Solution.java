package problem63;

class Solution {
    
    int m;
    int n;
    int[][] memo;
    int[][] obstacleGrid;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid==null || obstacleGrid.length == 0)
            return 0;
        
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        
        
        
            
        memo = new int[1000][1000];
        
        for (int i = 0; i < 1000; i++)
        	Arrays.fill(memo[i], -1);
        
        
        return rec(0,0); 
        
    }
    
    public int rec(int i, int j)
    {
       
        
        if (i >= m || j >= n)
            return 0;
        
        if (obstacleGrid[i][j]==1)
            return 0;
        
         if (i == m-1 && j == n-1)
            return 1;
        
        if (memo[i][j] != -1)
        	return memo[i][j];
        
     
        
        memo[i][j] = rec(i+1,j) + rec(i, j+1);
        return memo[i][j];
        
    }
}