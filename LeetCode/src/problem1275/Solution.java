package problem1275;

class Solution {
    public String tictactoe(int[][] moves) {
        
        int [][]grid = new int[3][3];
        
            
        int p = 0;
        
        for (int i = 0; i < moves.length; i++) {
            grid[moves[i][0]][moves[i][1]] = p+1;
​
            p = 1-p;
            
            int winner = getWinner(grid, moves[i][0], moves[i][1]);
            if (winner > 0) {
               if (winner == 1) {
                   return "A";
               } else {
                   return "B";
               }
            }
        }
        
        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
        
    }
    
    int  getWinner(int grid[][], int i, int j) {
        if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
            return grid[i][j];
        }
        
        if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
            return grid[i][j];
        }
        
        if (i == 1 && j == 1) {
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
                return grid[i][j];
            }
            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
                return grid[i][j];
            }
        } else {
            if ((i == 0 && j == 0) || (i == 2 && j == 2)) {
                if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[1][1] !=0) {
                    return grid[i][j];
                }   
            } else {
                if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[1][1] !=0) {
                   return grid[i][j];
                }
                
            }
        }
        
        return 0;
    }
}