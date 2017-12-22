package problem208;

class Trie {

    /** Initialize your data structure here. */
    
    final static int ALPH_SIZE = 26;
    
    TrieNode root;
    
    class TrieNode
    {
        public TrieNode children[];
        
        public TrieNode()
        {
            children = new TrieNode[ALPH_SIZE];  
            for (int i = 0; i < ALPH_SIZE; i++)
                children[i] = null;
        }
        
        public boolean endNode = false;
    }
    
    public Trie() {
        root = new TrieNode();
        root.endNode = true;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        if (word == null || word.length() == 0)
            return;
        
        int n = word.length();
        
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < n; i++)
        {
            idx = word.charAt(i) - 'a';
            
            if (node.children[idx] == null)            
                node.children[idx] = new TrieNode();
                                                                        
            node = node.children[idx];
            
            if (i == n-1)
                node.endNode = true;        
        }
        
        
                
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        if (word == null || word.length() == 0)
            return false;
        
        int n = word.length();
        
        TrieNode node = root;
        for (int i = 0; i < n; i++)
        {
            int idx = word.charAt(i) - 'a';
            
            if (node.children[idx] == null)
                return false;                
                                                                        
            node = node.children[idx];            
        }
        
        if (node != null && node.endNode)
            return true;
        return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        String word = prefix;
        if (word == null || word.length() == 0)
            return false;
        
        int n = word.length();
        
        TrieNode node = root;
        
        for (int i = 0; i < n; i++)
        {
            int idx = word.charAt(i) - 'a';
            
            if (node.children[idx] == null)
                return false;                
                                                                        
            node = node.children[idx];            
        }
        
        if (node != null && node != root ) 
           return true;
        
        return false;
    }
}

