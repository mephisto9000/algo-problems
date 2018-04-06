package problem661;

class Solution {
    
    int h; 
    int w;
    public int[][] imageSmoother(int[][] M) {
        
        h = M.length;
        w = M[0].length;
        int ans[][] = new int[h][w];
        
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                float color = 0;
                int cnt = 0;
                for (int i1 = i-1; i1 < i+2; i1++)
                    for (int j1 = j-1; j1 < j +2; j1++)
                    {
                        if (exists(i1,j1))
                        {
                            cnt++;
                            color += M[i1][j1];
                        }
                    }
                
                ans[i][j] = (int) Math.floor(color / cnt);
                        
            }
        
        return ans;
        
    }
    
    boolean exists(int i, int j)
    {
        if (i < 0 || i >= h || j < 0 || j >= w)
            return false;
        return true;
    }
}