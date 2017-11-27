package problem85;

class Solution {

    int mtxHor[][];
    int mtxVer[][];
    int w;
    int h;
    public int maximalRectangle(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0)
            return 0;
        
        //matrix;
        h = matrix.length;
        w = matrix[0].length;
        
        mtxHor = new int[h][w];
        mtxVer = new int[h][w];
        
        
        for (int i = 0; i < h; i++)
        {
        mtxHor[i][0] = Character.getNumericValue(matrix[i][0]);
        mtxVer[i][0] = Character.getNumericValue(matrix[i][0]);
        }
        
        for (int j = 0; j < w; j++)
        {
        mtxHor[0][j] = Character.getNumericValue(matrix[0][j]);
        mtxVer[0][j] = Character.getNumericValue(matrix[0][j]);
        }
        
        
        
        if (h == 1)
        {
        	int max = 0;
        	int lmax = 0;        			
        	for (int j = 0; j < w; j++)
        	{
        		if (matrix[0][j] =='1')
        			++lmax;
        		else
        			lmax = 0;
        	
        	if (lmax > max)
        		max = lmax;
        	}
        	
        	return max;
        }
        else
        if (w == 1)
            {
            	int max = 0;
            	int lmax = 0;        			
            	for (int i = 0; i < h; i++)
            	{
            		if (matrix[i][0] == '1')
            			++lmax;
            		else
            			lmax = 0;
            	
            	if (lmax > max)
            		max = lmax;
            	}
            	return max;
            }
        
        
        for (int i = 1; i < h; i++)
        {
            for (int j = 1; j < w; j++)
                if (matrix[i][j] == '0')
                {
                    mtxHor[i][j] = 0;
                    mtxVer[i][j] = 0;
                }
                else
                {
                	
                	/*
                	if (mtxHor[i][j-1] == 0 || mtxVer[i-1][j] == 0  ) //|| mtxVer[i-1][j-1] == 0  
                	{
                		mtxHor[i][j] = 1;
                		mtxVer[i][j] = 1;                		
                	}
                	else */
                	{
                		mtxHor[i][j] = mtxHor[i][j-1] + 1;
                		mtxVer[i][j] = mtxVer[i-1][j] + 1;
                	}
                }
                
        }
        
        int max = 0;
        
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                int v = mtxHor[i][j] * mtxVer[i][j];
                System.out.print(v);
                System.out.print(" ");
                if (v > max)
                    max = v;
            }
            System.out.println();
        }
        
        return max;
        
     
}
}