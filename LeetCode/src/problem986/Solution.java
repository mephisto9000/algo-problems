package problem986;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
      
      int idx1 = 0;
      int idx2 = 0;
      
      List<Interval> ans = new ArrayList<>();
      
      while (idx1 < A.length && idx2 < B.length) {
        Interval top = A[idx1];
        Interval bot = B[idx2];
        
        Interval t = intersection(top, bot);
        
        if (t!=null) {
          if (t.end == top.end)
            idx1++;
          if (t.end == bot.end)
            idx2++;
          ans.add(t);
        }
        else
        if (top.end < bot.start)
          idx1++;
        else if (bot.end < top.start)
          idx2++;
        else {
          idx1++;
          idx2++;
        }
        
      }
      
      Interval[] ansArr = new Interval[ans.size()];
      ansArr = ans.toArray(ansArr);

      return ansArr;     
    }
   
  Interval intersection(Interval a, Interval b) {  
    if (a.end < b.start || a.start > b.end)
      return null;
    Interval ans = new Interval (Math.max(a.start, b.start), Math.min(a.end, b.end));
    return ans;
  }
}