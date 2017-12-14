package problem221;

class Solution {
    
    int h;
    int w;
    char mtx[][];
    public int maximalSquare(char[][] matrix) {        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        mtx = matrix;
        h = mtx.length;
        w = mtx[0].length;
        
        int max = 0;// Integer.MAX_VALUE;
        
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                int off = 0;
                while(true)
                {
                    
                    boolean stop = false;
                    for (int y = i; y <= i+off; y++)
                        for (int x = j; x <= j + off; x++)
                            if (!isValid(y,x))
                                stop = true;
                    
                    if (stop)
                        break;
                    else
                        off++;
                }
                
                if (off > max)
                    max = off;
            }
        }                
        return (max*max);                
    }
    
    boolean isExists(int i, int j)
    {
        if (j >=0 && j < w && i >=0 && i < h)
            return true;
        return false;
    }
    
    boolean isValid(int i, int j)
    {
        if (isExists(i,  j) && mtx[i][j]=='1')
            return true;
        return false;
    }
    
    
}