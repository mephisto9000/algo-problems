package problem289;

class Solution {
    
    int tmpBoard[][];
    int board[][];
    int h;
    int w;
    public void gameOfLife(int[][] board) {        
        
        if (board == null || board[0].length == 0)
            return ;
        
        this.board = board;
        
        //Arrays.fill(tmpBoard = new int[h][w];
        
        h = board.length;
        w = board[0].length;
        
        tmpBoard = new int[h][w];
        
        //for (int i = 0; i < h; i++)
//            tmpBoard[i] = new int[w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                check(i,j);
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                board[i][j] = tmpBoard[i][j];
                
    }
    
    void check(int i, int j)
    {
        int neighbours = 0;
        if (isAlive(i-1,j-1))
            neighbours++;
        if (isAlive(i-1,j))
            neighbours++;
        if (isAlive(i-1,j+1))
            neighbours++;
        if (isAlive(i,j+1))
            neighbours++;
        if (isAlive(i+1,j+1))
            neighbours++;
        if (isAlive(i+1,j))
            neighbours++;
        if (isAlive(i+1,j-1))
            neighbours++;
        if (isAlive(i,j-1))
            neighbours++;        
        
        if (isAlive(i,j))
        {          
            if (neighbours <2)
                tmpBoard[i][j] = 0;
            else
            if (neighbours >=2 && neighbours <= 3)
                tmpBoard[i][j] = 1;    
            else
            if (neighbours > 3)                
                tmpBoard[i][j] = 0;
        }
        else
        {
            if (neighbours == 3)
                tmpBoard[i][j] = 1;
        }
    }
    
    boolean isAlive(int i, int j)
    {
        if ((i >= 0 && i < h) && (j >=0 && j < w) && (board[i][j] == 1))
            return true;
        else
            return false;
            
    }    
        
    
}