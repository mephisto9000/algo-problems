package problem212;

class Solution {
    int h;
    int w;
  
    public List<String> findWords(char[][] board, String[] words) {
      
      Set<String> ansSet = new HashSet<>();
      h = board.length;
      w = board[0].length;
      boolean visited[][] = new boolean[h][w];
      
      for (int z = 0; z < words.length; z++) {
        
        String s = words[z];        
        
        for (int i = 0; i < h; i++) {
          for (int j = 0; j < w; j++) {
              if (find(board, i,j, s, visited, 0)) {
                ansSet.add(s);
                break;
              }
          }
          if (ansSet.contains(s))
              break;
        }
      }
      
      List<String> ansList = new ArrayList(ansSet);
      return ansList;
        
    }
  
  boolean find(char[][]board, int i, int j, String s, boolean visited[][], int idx) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
      return false;
    
    visited[i][j] = true;
    boolean ans = false;
    if (board[i][j]==s.charAt(idx)) {
      if (idx == s.length()-1)
        ans = true;
      else {
        ans = find(board, i-1, j, s, visited, idx+1) || 
          find(board, i+1, j, s, visited, idx+1) ||
          find(board, i, j-1, s, visited, idx+1) ||
          find(board, i, j+1, s, visited, idx+1) ;
          
      }
    }
            
    visited[i][j] = false;
    return ans;
  }
}