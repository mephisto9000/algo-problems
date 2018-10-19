package problem723;

class Solution {
    int[][] board;
    boolean [][] marked;
    int markCnt = 0;
    
    int h, w;
    final int HORIZONTAL = 0;
    final int VERTICAL = 1;
    public int[][] candyCrush(int[][] board) {
        this.board = board;
        h = board.length;
        w = board[0].length;
        
        marked = new boolean[h][w];
        
        int x = 0;
        while(true) {
            x = mark();
            if (x==0)
                break;
            crush();
        }
        return board;
    }
    
    int mark() {
        
        int markIncrease = 0;
        for (int i = h-1; i >= 0; i--) {
                markCnt = 0;
                for (int j = 1; j < w; j++) {
                    if (board[i][j] != 0 && board[i][j] == board[i][j-1]) {
                        markCnt += markCnt == 0? 2 : 1;                        
                        
                    }
                    else 
                        markCnt = 0;                    
                    
                    if (markCnt >= 3) {
                        for (int x = 0; x < markCnt; x++) {
                            marked[i][j - x] = true;
                            markIncrease++;
                        }
                    }
                }                    
                        
            }            
            
            for (int j = 0; j < w; j++) {
                markCnt = 0 ;
                for (int i = h-2; i >= 0; i--) {
                    if (board[i][j] != 0 &&  board[i][j] == board[i+1][j]) {
                        markCnt += markCnt == 0? 2 : 1;
                    }
                    else
                        markCnt = 0;
                    
                    if (markCnt >= 3) {                        
                        for (int x = 0; x < markCnt; x++) {
                            marked[i + x][j] = true;                            
                            markIncrease++;
                        }
                    }
                }
            }
        
        return markIncrease;
    }
    
    
   void crush() {
       for (int i = h-1; i >= 0; i--)                 
            for (int j = 0; j < w; j++) {
                if (marked[i][j]==true) {
                    int it = i;
                    int mcnt = 0;
                    while(it >= 0 && marked[it][j]) {
                        mcnt ++;
                        it--;
                    }
                    
                    for (it = i; it>= 0; it--) {
                        if (it - mcnt >= 0) {
                            board[it][j] = board[it-mcnt][j];
                            marked[it][j] = marked[it-mcnt][j];
                        } else {
                            board[it][j] = 0;
                            marked[it][j] = false;
                        }
                            
                    }
                    
                }
            }
       
   }
}