package problem127;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      
      Map<String, Integer> distMap = new HashMap<>();
      Set<String> notUsed = new HashSet<>();
      
      for (String w : wordList) {
        distMap.put(w, 0);
        notUsed.add(w);
      }
      
      distMap.put(beginWord, 1);
      distMap.put(endWord, 0);
      notUsed.remove(beginWord);
      Queue<String> q = new LinkedList<>(); 
      q.add(beginWord);
      while(!q.isEmpty()) {
        String word = q.poll();
        Iterator<String> nuit = notUsed.iterator();
        while(nuit.hasNext()) {
          String w = nuit.next();
          if (dist(w,  word) == 1) {
            distMap.put(w, distMap.get(word)+1);
            nuit.remove();
            q.add(w);
          }
        }
      
      }      
      return distMap.get(endWord);              
    }
  
  int dist(String wordOne, String wordTwo) {
    int cnt = 0;
    for (int i = 0; i < wordOne.length(); i++) {
      cnt += (wordOne.charAt(i)==wordTwo.charAt(i))?0:1;
    }
    return cnt;
  }
}

