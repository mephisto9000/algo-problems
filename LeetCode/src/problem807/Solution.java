package problem807;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        int[] hMax = new int[h];
        int[] wMax = new int[w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                if (grid[i][j]  > hMax[i])
                    hMax[i] = grid[i][j];
                if (grid[i][j] > wMax[j])
                    wMax[j] = grid[i][j];
            }
        
        int ans = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                ans += Math.min(hMax[i], wMax[j]) - grid[i][j];
            }
        
        return ans;
        
        
    }
}