package problem498;

class Solution {

    int h, w, i, j;
    int ans[]; 
    int idx = 0;
    int mtx[][];

    public int[] findDiagonalOrder(int[][] matrix) {

      if (matrix == null || matrix.length == 0)
        return new int[0];
      h = matrix.length;
      w = matrix[0].length;
      mtx = matrix;
      ans = new int[h*w];      
      i--;
      while (true) {
        
       if (idx == ans.length)
         break;
        i++;
       goRightUp();
       j++;
       if (idx == ans.length)
         break;
       goLeftDown(); 
      }

      return ans;                  
    }

  void goRightUp() {
    while(i >=0) {
      if (check())
        ans[idx++] = mtx[i][j];
      i--;
      j++;
    }
  }
  
  void goLeftDown() {
    while(i <= h) {
      if (check())
        ans[idx++] = mtx[i][j];
      i++;
      j--;
    }
    
  }
  
  boolean check() {
    if (i < 0 || i >= h || j < 0 || j >= w)
      return false;
    return true;
  }
}