package problem211;

class WordDictionary {

    class Trie {
      char val;
      Trie[] children;
      boolean terminal = false;
      
      public Trie(char c) {
        this.val = c;
        children = new Trie[26];
      }
      
                  
    }
  
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie tmp = root;
        for (int i = 0; i < word.length(); i++) {
          int idx = word.charAt(i) - 'a';
          if (tmp.children[idx] == null) {
            tmp.children[idx] = new Trie(word.charAt(i));
          }
          tmp = tmp.children[idx];
        }      
      tmp.terminal = true;
    }
  
    boolean recSearch(String str, int idx, Trie node) {
      if (idx >= str.length()) {
        return true;
      }
      
      char c = str.charAt(idx);
      int cidx = c - 'a';
      
      if (c == '.') {
        for (int i = 0; i < 26; i++) {
          Trie tmp = node.children[i];
          if (check(idx, str, tmp, (char) ('a'+i)))
            return true;
        }
      } else {
        Trie tmp = node.children[cidx];
        return check(idx, str, tmp, c);
      }
      
      return false;
      
    }
  
  boolean check(int idx, String str, Trie tmp, char c) {
    if (idx == str.length()-1 ) {
      if (tmp != null && tmp.val == c && tmp.terminal) 
        return true;
      else
        return false;
    }
    if (tmp != null && recSearch(str, idx + 1, tmp))
        return true;
    return false;
  }
  
  
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return recSearch(word, 0, root );
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */