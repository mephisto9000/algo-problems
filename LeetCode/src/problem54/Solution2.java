package problem54;

class Solution {
    
    
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new LinkedList<>();
        boolean[][] visited;
        
        
        
        if (matrix.length == 0 || matrix[0].length == 0)
            return ans;
        
        int jr = matrix[0].length-1;
        int jl = 0;
        int iu = 0;
        int id = matrix.length-1;

        int j = jl;
        int i = iu;
        while(jl <= jr && iu <= id) {

            System.out.println(i+" "+j);
            for (; j <= jr; j++)
                ans.add(matrix[i][j]);
                
            j--;
            i++;
            
            for (; i <= id; i++)
                ans.add(matrix[i][j]);
            i--;
            j--;

            if (jl < jr && iu < id) {
            for (; j >= jl; j--)
                ans.add(matrix[i][j]);
            j++;
            i--;
            for (;i > iu; i--)
                ans.add(matrix[i][j]);
            i++;
            j++;
            }
            iu ++;
            id --;
            jl++;
            jr--;
                
        }
         
     return ans;           
    }
    
    
}}
