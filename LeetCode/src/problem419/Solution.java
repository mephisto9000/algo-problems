package problem419;

class Solution {
    public int countBattleships(char[][] board) {     
        
        boolean shipDetected = false;
        int count = 0;
        for (int i = 0; i<board.length; i++ )
        {
            shipDetected = false;
            for (int j = 0; j < board[0].length ; j++)
            {
                if (board[i][j] == 'X')
                {
                    if (!shipDetected)
                    {
                        if (i > 0 && board[i-1][j] == 'X')
                            continue;
                        
                        count ++;
                        shipDetected = true;
                    }
                }
                else
                {
                    shipDetected = false;
                }
            }
        }
        
        
        return count;
        
    }
}