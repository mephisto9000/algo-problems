package problem37;

class Solution {
    
    char[][] board = null;
    char[][] origBoard = null;
    Set<Integer> box[][] = null;
    Set<Integer>  vSet[] = null;
    Set<Integer>  hSet[] = null;
    
    public void solveSudoku(char[][] board) {
        
        this.board = board;
        origBoard = new char[9][9];
        
        box = new HashSet[9][9];
        vSet = new HashSet[9];
        hSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            box[i] = new HashSet[9];
            vSet[i] = new HashSet();
            hSet[i] = new HashSet();
        }
        
        for (int i = 0; i< 9; i++)            
            for (int j = 0; j < 9; j++) {
                box[i][j] = new HashSet();
                origBoard[i][j] = board[i][j];   
                
                int bi = i/3;
                int bj = j/3;
                if (origBoard[i][j]!='.') {
                    
                    int v = Character.getNumericValue(origBoard[i][j]);
                    box[bi][bj].add(v);
                    hSet[i].add(v);
                    vSet[j].add(v);
                }
                                
        }
        
        rec(0,0);
        
         
    }
    
    boolean rec(int i, int j) {
        
        if (i == 9)
            return true;
        
        int nextj = j; 
        int nexti = i;
            
        if (nextj < 8)
            nextj++;
        else {
            nextj = 0;
            nexti++; 
        }
 
            
        if (origBoard[i][j] != '.')
            return rec(nexti,nextj);
        
        
        for (int x = 0; x < 9; x++) {
            
            int bi = i/3;
            int bj = j/3;
                                   
            if (vSet[j].contains(x+1) || hSet[i].contains(x+1) || box[bi][bj].contains(x+1)) 
                continue;
            
            vSet[j].add(x+1); 
            hSet[i].add(x+1); 
            box[bi][bj].add(x+1);
            
            board[i][j] = (char) ((x+1) + '0');
                       
            if (nexti == 9)
                return true;
            else {
                if (rec(nexti,nextj))
                    return true;
                else {
                    vSet[j].remove(x+1);
                    hSet[i].remove(x+1);
                    box[bi][bj].remove(x+1);
                }
            }
            
        }
        
        return false;
    }
}