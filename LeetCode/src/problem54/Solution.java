package problem54;

import java.util.LinkedList;
import java.util.List;

class Solution {
    
     
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new LinkedList<Integer>();
        
        int ir = matrix.length-1;
        int jr = 0;
        int il = 0;
        int jl = 0;
        
        if (ir >= 0)
            jr = matrix[0].length-1;
        
        if (jl == jr)
        {
        	for (int i = 0; i <= ir; i++)
        		 ans.add(matrix[i][0]);
        }
        else
        if (il == ir)
        {
            for (int j = 0; j <= jr; j++)
            		 ans.add(matrix[0][j]);
        }
        else        	
        while ( il <= ir && jl <= jr)        
        {
        	                    	
        	for (int j = jl; j <= jr; j++)
        		ans.add(matrix[il][j]);
        	il++;
        	
        	for (int i = il; i <= ir; i++)
        		ans.add(matrix[i][jr]);
        	jr--;
        	
        	
        	if (il <= ir)
        	for (int j = jr; j >= jl; j--)
        		ans.add(matrix[ir][j]);
        	ir--;
        	
        	if (jl <= jr)
        	for (int i = ir; i >= il; i--)
        		ans.add(matrix[i][jl]);
        	jl++;
        	                     
            }
                
        
        return ans;
        }
        
    
}