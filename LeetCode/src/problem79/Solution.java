package problem79;

class Solution {
    
    class Pair<L,R>{
        public L left;
        public R right;
        
        @Override
        public boolean equals(Object o)
        {
        	Pair<L,R> po = (Pair<L,R>) o; 
        	if (this.left.equals(po.left) && this.right.equals(po.right))
        		return true;
        	return false;
        }
        
        public int hashCode() {
        	return 37 * left.hashCode() + right.hashCode(); 
        	}
        
        
    }
    
    char [][] board;
    String word;
    int h;
    int w;
    
    public boolean exist(char[][] board, String word) {
        
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0)
            return false;
        
        h = board.length;
        w = board[0].length;
        
        this.board = board;
        this.word = word;
        
        List<Pair<Integer,Integer>> init = new LinkedList();
        int ic = word.charAt(0);
        for (int i =0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                if (board[i][j] == ic)
                {
                    Pair<Integer, Integer> p = new Pair();
                    p.left = i;
                    p.right = j;
                    
                    init.add(p);
                }
                
                
            }
        
        for (Pair<Integer, Integer> p : init)
        {
            if (canFind(p.left, p.right, 0, new HashSet()))
                return true;
        }
        
        return false;
        
    }
    
    boolean canFind(int bi, int bj, int widx, Set<Pair> used)
    {
        if (widx >= word.length())
            return true;
        if (bi < 0 || bi >= h || bj < 0 || bj >= w)
            return false;
        
        Pair<Integer, Integer> p = new Pair();
        p.left = bi;
        p.right = bj;
        
        if (used.contains(p))
            return false;
        
        if (board[bi][bj] != word.charAt(widx))
            return false;
        
        used.add(p);
        
        boolean ans = canFind(bi-1, bj, widx+1, used) || canFind(bi, bj-1, widx+1, used) || canFind(bi+1, bj, widx+1, used) || canFind(bi, bj+1, widx+1, used);
        
        used.remove(p);
        
        return ans;
        
    }
}
