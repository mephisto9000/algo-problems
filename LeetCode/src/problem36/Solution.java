package problem36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int h = board.length;
        int w = board[0].length;
        
        
        for (int i = 0; i < h; i++)
        {
            Set<Character> s = new HashSet();
            for (int j = 0; j < w; j++)
            {
                if (board[i][j] != '.' && s.contains(board[i][j]))
                {
                    return false;
                }
                s.add(board[i][j]);
            }
        }
        
         for (int j = 0; j < w; j++)
        {
            Set<Character> s = new HashSet();
            for (int i = 0; i < h; i++)
            {
                if (board[i][j] != '.' &&  s.contains(board[i][j]))
                {
                    return false;
                }
                s.add(board[i][j]);
            }
        }
        
        
        for (int i = 0; i < h; i+=3)
        {
            for (int j = 0; j < w; j+=3)
            {
               Set<Character> s = new HashSet();
               for (int ii = 0; ii < 3; ii++)               {                 
                   
                   for (int jj = 0; jj < 3; jj++)
                   {
                   if (board[i+ii][j+jj] != '.' &&  s.contains(board[i+ii][j+jj]))
                   {
                       return false;
                   }
                   s.add(board[i+ii][j+jj]);
                   }
               }               
               
                
                
            }
        }
        
        return true;
        
        
        
        
    }
}