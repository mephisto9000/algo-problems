package problem661;

class Solution {
    int h;
    int w;
    public int[][] imageSmoother(int[][] M) {
      h = M.length;
      w = M[0].length;
      int ans[][] = new int[h][w];
            
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          int cnt = 0;
         
          cnt += exist(M, ans, i,-1, j,0); 
          cnt += exist(M, ans, i,1, j,0); 
          cnt += exist(M, ans, i,0, j,-1); 
          cnt += exist(M, ans, i,0, j,1); 
          cnt += exist(M, ans, i,-1, j,-1); 
          cnt += exist(M, ans, i,-1, j,1);
          cnt += exist(M, ans, i,1, j,-1);
          cnt += exist(M, ans, i,1, j,1);
          cnt += exist(M, ans, i,0, j,0);
          ans[i][j] = (int) Math.floor(((float)ans[i][j])/cnt);  
          
        }
      }
      return ans;
    }
  
  int exist(int arr[][], int ans[][], int i, int offi, int j, int offj) {
    int i2 = i+offi;
    int j2 = j+offj;
    if (i2 < 0 || j2 < 0 || i2 >= arr.length || j2 >= arr[0].length)
      return 0;
    ans[i][j] += arr[i2][j2];
    return 1;
  }
}