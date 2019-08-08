package problem911;

class TopVotedCandidate {
	  
    List<Integer> timesList;
    Map<Integer, Integer> winMap;
    Map<Integer, Integer> voteBuckets;
      
    public TopVotedCandidate(int[] persons, int[] times) {
                  
      voteBuckets = new HashMap<>();  
      winMap = new HashMap<>();
      timesList = new ArrayList<>();

      int lastWinner = -1;
      int winnerCount = -1;
      
      for (int i = 0; i < times.length; i++) {
        int guy = persons[i];
        int curCnt = voteBuckets.getOrDefault(guy, 0) + 1;
        voteBuckets.put(guy,curCnt);
                  
        if (curCnt >= winnerCount) {
            lastWinner = guy;
            winnerCount = curCnt;
        }  
        
        winMap.put(times[i], lastWinner);
        timesList.add(times[i]);
        
      }
        
    }
    
    public int q(int t) {
           
      int v = Collections.binarySearch(timesList, t);
            
      if (v >= 0) {
        return winMap.get(timesList.get(v));
      } else {
        return winMap.get(timesList.get(-v -2));
      }
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */