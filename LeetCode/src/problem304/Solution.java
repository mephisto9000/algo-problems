package problem304;

class NumMatrix {
    
    int sums[][];
    int w;
    int h;    
    boolean empty = false;

    public NumMatrix(int[][] matrix) {
        
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    	{
    		empty = true;
    		return;
    	}
    	    	
        h = matrix.length;
        w = matrix[0].length;
                
        sums = new int[h+1][w+1];
                
        for (int i = h-1; i >=0; i--)
        for (int j = w-1; j>= 0; j--)
        {
            sums[i][j] = (sums[i+1][j] -  sums[i+1][j+1])  + sums[i][j+1] + matrix[i][j];
        }
                       
    }
                
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	
    	if (empty)
    		return 0;
    	
        return (sums[row1][col1] -  (sums[row2+1][col1] - sums[row2+1][col2+1]) - sums[row1][col2+1]) ;
    }
}