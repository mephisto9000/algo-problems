package problem64;



class Solution {
   
   int m;
   int n;
   int[][] memo;
   int[][]grid;
   
  // public int uniquePaths(int m, int n) {
   public int minPathSum(int[][] grid) {
       
       this.grid = grid;
       
       if (grid == null)
           return 0;
       this.m = grid.length;
       
       if (m == 0)
           return 0;
       this.n = grid[0].length;
   
       
       memo = new int[1000][1000];
       
       for (int i = 0; i < 1000; i++)
       	Arrays.fill(memo[i], -1);
       
       
       return rec(0,0); 
   }
   
   public int rec(int i, int j)
   {
       if (i == m-1 && j == n-1)
           return grid[i][j]; //10000;
       
       
       
       if (memo[i][j] != -1)
       	return memo[i][j];
       
       if (i >= m || j >= n)
           return 10000;
       
       
       int v1 = rec(i+1,j);
       int v2 = rec(i, j+1);
       
       if (v1 < v2)
           memo[i][j] = v1 + grid[i][j];
       else
           memo[i][j] = v2 + grid[i][j];
       
           
       return memo[i][j];
       
   }
}