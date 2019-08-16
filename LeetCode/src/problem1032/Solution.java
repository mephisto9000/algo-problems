package problem1032;

class StreamChecker {    
    class Trie {
        boolean terminal = false;
        char val;
        Trie[] children;
        public Trie(char val) {
            this.val = val;
            this.children = new Trie[26];
        }
    }

    Trie root;
    List<Trie> rolls;
    String words[];

    public StreamChecker(String[] words) {
        root = new Trie(' ');
        rolls = new ArrayList<>();
        
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            addWord(words[i]);
        }
    }
    
    public void addWord(String s) {
        Trie tmp = root;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            if (tmp.children[idx] == null) {
                tmp.children[idx] = new Trie(c);
            }
            tmp = tmp.children[idx];
        }
        
        tmp.terminal = true;
    }

    public boolean query(char letter) {
        int idx = letter - 'a';
        boolean ans = false;

        rolls.add(root);
        List<Trie> nextList = new ArrayList<>();
        Iterator<Trie> it = rolls.iterator();
        while(it.hasNext()) {
          Trie tmp = it.next();
          Trie kid = tmp.children[idx];
          if (kid != null) {
            nextList.add(kid);
            if (kid.terminal)
              ans = true;
          }          
        }      
        rolls = nextList;                     
        return ans;
    }    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */