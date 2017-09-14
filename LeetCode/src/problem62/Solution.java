package problem62;


import java.util.Arrays;


class Solution {
   
   int m;
   int n;
   int[][] memo;
   
   public int uniquePaths(int m, int n) {
       this.m = m;
       this.n = n;     
   
       
       memo = new int[1000][1000];
       
       for (int i = 0; i < 1000; i++)
       	Arrays.fill(memo[i], -1);
       
       
       return rec(0,0); 
   }
   
   public int rec(int i, int j)
   {
       if (i == m-1 && j == n-1)
           return 1;
       
       if (memo[i][j] != -1)
       	return memo[i][j];
       
       if (i >= m || j >= n)
           return 0;
       
       memo[i][j] = rec(i+1,j) + rec(i, j+1);
       return memo[i][j];
       
   }
}