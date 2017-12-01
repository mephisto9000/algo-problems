package problem240;


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int i = 0; 
        int j = w - 1;
        while (true)
        {
            int v = matrix[i][j] ;
            if (v == target)
                return true;
               
            if (v > target)    
                j --;
            else
                i++;
            
            if (j < 0 || i > j || i >= h )
                break;
        }
        
        i = h-1;
        j = 0;
        while (true)
        {
            int v = matrix[i][j] ;
            if (v == target)
                return true;
               
            if (v < target)    
                j ++;
            else
                i--;
            
            if (j >= w || j < 0 || i < j)
                break;
        }        
        
        return false;
        
    }
}