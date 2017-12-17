package problem85;

import java.util.Stack;

class Solution {

    int mtx[][];
    int w;
    int h;
    public int maximalRectangle(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0)
            return 0;
                
        h = matrix.length;
        w = matrix[0].length;
        
        mtx = new int[h][w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                mtx[i][j] = matrix[i][j] -'0';
              
        
        for (int j = 0; j < w; j++)
        {        
            for (int i = h-1; i >=0; i--)
            {
                if (mtx[i][j]==0 || i == 0)
                {
                    int i1 = i+1;                    
                    while (i1 < h && mtx[i1][j] != 0)
                    {
                        mtx[i1][j] = mtx[i1-1][j]+1;
                        
                        i1++;                        
                    }
                }
            }
        } 
 
        Stack<Integer> st = new Stack();
        int max = 0;
        for (int i = 0; i < h; i++)
        {
            st.clear();
            for (int j = 0; j <= w; j++)
            {
                if (st.isEmpty() || (j < w && mtx[i][j] >= mtx[i][st.peek()]))
                {
                    st.push(j);
                }
                else
                {
                    int top = st.pop();
                    max = Math.max(max, mtx[i][top] * (!st.isEmpty() ? j - st.peek() - 1 : j));
                    j--;
                }
                    
            }
        }
            
        return max;
        
     
}
}