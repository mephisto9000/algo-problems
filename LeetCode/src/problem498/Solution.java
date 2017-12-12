package problem498;

class Solution {
    final int RIGHT = 0;
    final int DOWN = 1;
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        
        int w = matrix[0].length;
        int h = matrix.length;
        
        int ans[] = new int[h*w];
        
        int i = 0;
        int j = 0;
        int z = 0;
        
        
        int mode = RIGHT;
        while(i < h && j < w)
        {
            ans[z++] = matrix[i][j];
            
            if (mode == RIGHT)
            {
                if (i > 0)
                {
                    if (j < w-1)
                    {
                        i --;
                        j++;
                    }
                    else
                    {
                        i++;
                        mode = DOWN;
                    }
                }
                else
                {
                    if (j < w-1)
                    {
                        j++;
                        mode = DOWN;
                    }
                    else
                    {
                        i++;
                        mode = DOWN;
                    }
                }
            }
            else
            {
                if (i < h-1)
                {
                    if (j >0)
                    {
                        i++;
                        j--;
                    }
                    else
                    {
                        i++;
                        mode = RIGHT;
                    }
                }
                else
                {
                    j++;
                    mode = RIGHT;
                }
            }
        }
        
        return ans;
        
    }
}