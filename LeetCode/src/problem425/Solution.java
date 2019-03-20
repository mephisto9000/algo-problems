package problem425;

class Solution {
    
    class TrieNode {
        int val;  
        TrieNode childs[];
        boolean terminal;
        List<String> words;
        public TrieNode(int v) {
            val = v; 
            childs = new TrieNode[26];
            terminal = false;
            words = new LinkedList<>();
        }
    }
    
    TrieNode root;
    
    void addWord(String w) {
        TrieNode node = root;
        int idx = 0;
        
        while(idx < w.length()) {
                int v = (w.charAt(idx)-'a');
                if (node.childs[v]==null)
                    node.childs[v] = new TrieNode(v);
                node.words.add(w);
                node = node.childs[v];
                idx ++;            
        }
        node.words.add(w);
        
        node.terminal = true;
        
    }
    
    TrieNode getWord(String w) {
        TrieNode node = root;
        
        int idx = 0;
        
        while(idx < w.length()) {
            int v = w.charAt(idx)-'a';
            if (node.childs[v]!=null) 
                node = node.childs[v];
            else {
                node = null;
                break;
            }   
          idx++;
        }
        
        return node;
        
    }
    
    List<List<String>> ans;
    int n;
    String[] words;
    public List<List<String>> wordSquares(String[] words) {
        root = new TrieNode(' ');
        ans = new LinkedList<>();
        n = words[0].length();
        this.words = words;
              
        for (String w : words)
            addWord(w);
      
        List<String> tmp = new ArrayList<>();
         
        rec(tmp);

       return ans;
    }
  
    void rec(List<String> tmp ) {
        
      if (tmp.size() == n) {
           ans.add(new LinkedList(tmp));
          return;
      }
        
      StringBuffer sb = new StringBuffer();
      
      for (int i = 0; i < tmp.size(); i++)
        sb.append(tmp.get(i).charAt(tmp.size()));
      
      int l = sb.length();
        
      
      for (int j = 0; j < 26; j++) {
          sb.append( (char) ('a'+j));
          
          String x = sb.toString();
          TrieNode tn = getWord(sb.toString());
          sb.setLength(l);
          if (tn == null) 
              continue;
                                   
       if (tn.words != null) {
           
       for (String w: tn.words) {           
           tmp.add(w);
           rec(tmp); 
           
           tmp.remove(tmp.size()-1);
          }                       
      }                    
      }
    }
}