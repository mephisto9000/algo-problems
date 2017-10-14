package problem74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0)          
            return false;   
        
        int i = 0;
        int j = matrix.length;
        
        int oldM = - 100000;
        while(i <= j)
        {
            int m  = (i + j)/2;
            
            if (m == oldM )
            	break;
            oldM = m;
            
            if (target<matrix[m][0])
            {
                j = m;
                continue;
            }
            else
            if (target>matrix[m][0])
            {
                i = m;
                continue;
            }
            return true;

        }
        
        int j1 = 0;
        int j2 = matrix[i].length;
        
        oldM = -1000000;
        while( j1 <=j2)
        {
            int m = (j1 + j2)/2;
            
            if (m == oldM )
            	break;
            oldM = m;
            
            if (target < matrix[i][m])
            {
                j2 = m;
                continue;
            }
            else
            if (target > matrix[i][m])
            {
                j1 = m;
                continue;
            }
            return true;
        }
        
        if (matrix[i][j1] == target)
            return true;
        return false;
        
            
        
        
    }
}