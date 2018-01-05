package problem211;

class WordDictionary {

    
    class Trie
    {
        public Trie[] children;
        public static final int alpha_len = 26;        
        
        public boolean isTerminal = false;
        
        public Trie()
        {
            children = new Trie[alpha_len];            
            Arrays.fill(children, null);            
        }        
        
    }
    
    Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        int idx = 0;
        Trie node = root;
        while (idx < word.length())
        {
            int cidx = (int) word.charAt(idx) - 'a';
            
            if (node.children[cidx] == null)
            {
                node.children[cidx] = new Trie();
            }
            
            node = node.children[cidx];
            
            if (idx == word.length()-1)
                node.isTerminal = true;
            
            idx++;
        }
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
       
       
        
        Queue<Trie> trieq = new LinkedList();
        Queue<Integer> idxq = new LinkedList();
        
        trieq.add(root);
        idxq.add(0);
        
        Trie node = null;
        while(!trieq.isEmpty())
        {
            node = trieq.poll();
            int idx = idxq.poll();
            
            if (idx >= word.length())
                continue;
            
            if (word.charAt(idx) =='.')
            {
                for (int i = 0; i <Trie.alpha_len; i++ )
                {
                    if (node.children[i]!=null) //&& idx + 1 < word.length()
                    {
                        if (idx == word.length()-1 && node.children[i].isTerminal)
                            return true;
                        else
                        {
                            trieq.add(node.children[i]);
                            idxq.add(idx+1);
                        }
                    }
                }
            }
            else
            {
                int cidx = (int) word.charAt(idx) - 'a';
                if (node.children[cidx] == null)
                    continue;
                
                 if (idx == word.length()-1 && node.children[cidx].isTerminal)
                     return true;
                else
                {
                    trieq.add(node.children[cidx]);
                    idxq.add(idx + 1);
                }
            }
            
            //if (Trie.alpha_len)
        }
        
        //if (node != null && node.isTerminal)
//            return true;
  //      else
            return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */