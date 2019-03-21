package problem417;

class Solution {
	  
    int h;
    int w;
  
    boolean p;
    boolean a;
    boolean visited[][];
    int matrix[][];
    public List<int[]> pacificAtlantic(int[][] matrix) {
      List<int[]> ans = new LinkedList();
      
      if (matrix.length == 0 || matrix[0].length == 0)
        return ans;
      h = matrix.length;
      w = matrix[0].length;
      visited = new boolean[h][w];
      
      this.matrix = matrix;
      
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          a = false;
          p = false;
          rec(i,j, i, j);
          
          if (a && p) 
            ans.add(new int[] {i,j});
            
        }
      }
      return ans;
    }
  
    void rec(int i, int j, int pi, int pj) {
      if (i < 0 || j < 0) {
        a = true;
        return;
      }
      
      if (i >= h || j >= w) {
        p = true;
        return;
      }
      
      if (visited[i][j] || matrix[i][j]>matrix[pi][pj])
        return;
      
      visited[i][j]=true;
      
      rec(i-1, j, i, j);
      rec(i+1, j,i, j);
      rec(i, j-1,i, j);
      rec(i, j+1,i, j);
      
      visited[i][j]=false;
    }
}