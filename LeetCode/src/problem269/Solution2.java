package problem269;

class Solution {
	  
    class Node {
      char c;
      List<Integer> childrenIdxs;
      boolean visited = false;
      
      public Node(char c) {
        this.c = c;
        this.visited = false;
        childrenIdxs = new ArrayList<>();
      }
    }

    Node letters[];
    public String alienOrder(String[] words) {
        letters = new Node[26];      
        for (int i = 0; i < words.length; i++) {          
          int j = 0;          
          if (i > 0) {           
            while(j < words[i].length() && j < words[i-1].length() && words[i-1].charAt(j) == words[i].charAt(j)) {
              j++;
            }
            
            if (j < words[i].length() && j < words[i-1].length()) {
              char c1 =  words[i-1].charAt(j);
              char c2 =  words[i].charAt(j);
              int idx1 = c1 - 'a';
              int idx2 = c2 - 'a';
              
              if (letters[idx1] == null) {
                letters[idx1] = new Node(c1);
              }
              
              if (letters[idx2] == null) {
                letters[idx2] = new Node(c2);
              }
              if (lookup(idx2, idx1)) {
                return "";
              }
              letters[idx1].childrenIdxs.add(idx2);
            }
                       
          }
          
           while(j < words[i].length()) {
              char cL =  words[i].charAt(j);             
              int idxL = cL - 'a';
              if (letters[idxL] == null) {
                letters[idxL] = new Node(cL);
              }
              j++;
            }
          
        }
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        topSort(sb, i);
      }
      
      return sb.reverse().toString();   
    }
  
  boolean lookup(int idx1, int idx2) {
    if (idx1 == idx2) {
      return true;
    }    
    Node n = letters[idx1];
    for (Integer i : n.childrenIdxs) {
      if (lookup(i, idx2))
        return true;
    }    
    return false;      
  }
  
  void topSort(StringBuilder sb, int idx) {
    Node l = letters[idx];
    if (l == null || l.visited)
      return;
    
    l.visited = true;   
    Iterator<Integer> it = l.childrenIdxs.iterator();    
    while(it.hasNext()) {
      int kid = it.next();
      topSort(sb,kid);
    }    
    sb.append(l.c);
  }
}