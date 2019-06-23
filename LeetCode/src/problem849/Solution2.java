package problem849;

class Solution {
    public int maxDistToClosest(int[] seats) {
      
      int nextIdx = -1;
      int prevIdx = -1;
      
      int max = 0;
      int n = seats.length;
      
      for (int i = 0; i < n; i++) {
        int prevDist = Integer.MAX_VALUE;
        int nextDist = Integer.MAX_VALUE;
        
        
        if (seats[i] == 1) {
          prevIdx = i;
          continue;
        }
        
        //at 0
        if (nextIdx < i) {
          nextIdx = i+1;
          while(nextIdx < n && seats[nextIdx]==0)
            nextIdx++;
        }
          
        if (prevIdx >= 0)
          prevDist = i - prevIdx;
        
        if (nextIdx < n)
          nextDist = nextIdx - i;
        
        max = Math.max(max, Math.min(prevDist, nextDist));
               
      }
      
      return max;
        
    }
}