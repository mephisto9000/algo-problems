package problem73;

class Solution {
    
    List<Integer> zi;
    List<Integer> zj;
    int m;
    int n;
    
    public void setZeroes(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0)
            return;
        
        m = matrix.length;
        n = matrix[0].length;
        
        zi = new LinkedList<Integer>();
        zj = new LinkedList<Integer>();
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    zi.add(i);
                    zj.add(j);
                }
            }
        
        Iterator iti = zi.iterator();
        Iterator itj = zj.iterator();
        
        while(iti.hasNext())
        {
            int ii = (Integer)iti.next();
            int jj = (Integer)itj.next();
            
            for (int i = 0; i < m; i++)
                matrix[i][jj] = 0;
            
            for (int j = 0; j < n; j++)
                matrix[ii][j] = 0;
        }
        
        
    }
}
