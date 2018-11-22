package problem348;

class TicTacToe {

    /** Initialize your data structure here. */
    
    int mtx[][];
    int n;
    public TicTacToe(int n) {
        mtx = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        mtx[row][col] = player;
        
        int hor = 0;
        int ver = 0;
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < n; i++) {
            if (mtx[i][col]==player)
                hor++;
            if (mtx[row][i]==player)
                ver++;
            if (mtx[i][i]==player)
                diag1++;
            if (mtx[i][n-i-1]==player)
                diag2++;
        }
        
        if (hor == n || ver == n || diag1 == n || diag2 == n)
            return player;
        return 0;
        
    }
    
   
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */