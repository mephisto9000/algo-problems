package problem212;

class Solution {
    
    class TrieNode
    {
       TrieNode children[];
       final int n = 26;
       public boolean isTerminal;
       
        public TrieNode()
        {
            children = new TrieNode[n];
            
            isTerminal = false;
        }
                        
    }
    
    public void insert(String word)
    {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int idx = c - 'a';
            
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            
            node = node.children[idx];
        }
        
        node.isTerminal = true;
        
    }
    
         
    public TrieNode getLastNode(TrieNode node,char c)
    {                 
        int idx = c - 'a';                         
        return node.children[idx];
    }
        
    
    
    TrieNode root = null;
    
    class ChessNode
    {
        int i;
        int j;
        
        public ChessNode(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    
    
    Set<String> ansSet = null;
    char[][] board;
    ChessNode nodes[][];
    int h ;
    int w;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        root = new TrieNode();
        ansSet = new HashSet();
        this.board = board;
        h = board.length;
        w = board[0].length;
        
        nodes = new ChessNode[h][w];
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                nodes[i][j] = new ChessNode(i, j);
        
        for (int i = 0; i < words.length; i++)
        {
            insert(words[i]);
        }
        
        Set<ChessNode> chessSet = new HashSet();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
            {
                chessSet.clear();
                dfs(i, j, chessSet, sb, root);
            }
        
        List<String> ans = new LinkedList<String>(ansSet);
        
        return ans;
        
        
    }
    
    
    public void dfs(int i, int j, Set<ChessNode> chessSet, StringBuffer sb, TrieNode node)
    {
        if (!isValid(i, j, chessSet))
            return ;
        char c = board[i][j];
        
        TrieNode nextNode = getLastNode(node, c) ;
        if (nextNode == null)
            return;
        sb.append(c);
        
        if (nextNode.isTerminal)
            ansSet.add(sb.toString());
        
        chessSet.add(nodes[i][j]);
        
        
        dfs(i - 1, j, chessSet, sb, nextNode);
        dfs(i + 1, j, chessSet, sb, nextNode);
        dfs(i, j - 1, chessSet, sb, nextNode);
        dfs(i, j + 1, chessSet, sb, nextNode);
        
        sb.setLength(sb.length() - 1);
        chessSet.remove(nodes[i][j]);
                                                    
    }
    
    
    public boolean isValid(int i, int j,  Set<ChessNode> chessSet )
    {
        if (i < 0 || i >= h || j < 0 || j >= w)
            return false;
        ChessNode cn = nodes[i][j];
        if (chessSet.contains(cn))
            return false;
        return true;
    }
}