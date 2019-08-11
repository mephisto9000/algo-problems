package problem642;

class AutocompleteSystem {
  
    
    class Trie {
      int val;
      boolean terminal;
      Trie children[];
      Set<String> successors;
      public Trie(int val) {
        this.val = val;
        terminal = false;
        children = new Trie[27];
        successors = new HashSet<>();
      }
    }
  
    void addToTrie(String word, int pop) {      
      Trie node = root;      
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int idx;
        if (c == ' ')
          idx = 26;
        else
          idx = c - 'a';        
        if (node.children[idx] == null) {
          node.children[idx] = new Trie(idx);
        }
        node = node.children[idx];   
        node.successors.add(word);
      }
      node.terminal = true;
      int lastPop = popularity.getOrDefault(word, 0);
      popularity.put(word, lastPop + pop);
    }
  
    List<String> search(Trie node, String s) {
      
      int len = s.length();      
      char c = s.charAt(len - 1);
      if (c == '#') {
        addToTrie(s.substring(0, len-1), 1);
        return new LinkedList<>();
      }
      
      int idx;
      if (c == ' ')
          idx = 26;
        else
          idx = c - 'a';      
      if (node.children[idx] == null)
        node.children[idx] = new Trie(idx);
            
      current = node.children[idx];      
      return new LinkedList<String>(current.successors);
    }
       
    Trie root;
    Map<String, Integer> popularity;
  
    public AutocompleteSystem(String[] sentences, int[] times) {
      root = new Trie(0);
      current = root;
      popularity = new HashMap<>();
      for (int i = 0; i < sentences.length; i++)
        addToTrie(sentences[i], times[i]);        
    }
    
    Trie current;
    StringBuffer sb = new StringBuffer();
    public List<String> input(char c) {
      sb.append(c);
        List<String> candidates = search(current, sb.toString());
        List<String> ans = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
          @Override
          public int compare(String s1, String s2) {
            int p1 = popularity.get(s1);
            int p2 = popularity.get(s2);
            if (p1 != p2) {
              return p2 - p1;
            } else {
              return s1.compareTo(s2);
            }
          }
        });
      pq.addAll(candidates);
      for (int i = 0; i < 3; i++) {
        if (!pq.isEmpty())
          ans.add(pq.poll());
      }

      if (c == '#') {
        current = root;
        sb.setLength(0);
      }

      return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */