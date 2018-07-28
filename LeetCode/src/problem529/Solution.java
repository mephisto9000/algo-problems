package problem529;

class Solution {
    char[][]board;
    boolean visited[][];
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int c0 = click[0];
        int c1 = click[1];
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        
        if (board[c0][c1] == 'M') {
            board[c0][c1] = 'X';                          
        } else
        {
            rec(c0, c1);
        }
        
        return board;        
    }
    
    void rec(int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j>= board[0].length || visited[i][j] || board[i][j] != 'E')
            return;
        
        visited[i][j] = true;
        
        int cnt = 0;
        cnt += isMine(i-1, j-1);
        cnt += isMine(i-1, j);
        cnt += isMine(i-1, j+1);
        cnt += isMine(i, j-1);
        cnt += isMine(i, j+1);
        cnt += isMine(i+1, j-1);
        cnt += isMine(i+1, j);
        cnt += isMine(i+1, j+1);
        
        if (cnt > 0)
            board[i][j] = (char)(cnt + '0');
        else {
            board[i][j] = 'B';
            rec(i-1, j-1);
            rec(i-1, j);
            rec(i-1, j+1);
            rec(i, j-1);
            rec(i, j+1);
            rec(i+1, j-1);
            rec(i+1, j);
            rec(i+1, j+1);
        }
        
    }
    
    int isMine(int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j>= board[0].length || board[i][j] != 'M')
            return 0;
        return 1;
    }
}