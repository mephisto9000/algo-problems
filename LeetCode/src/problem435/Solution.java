package problem435;

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
      
    public int eraseOverlapIntervals(Interval[] intervals) {
                                  
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end; 
            }
        });
        
        
        int prev = 0;
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
             if (intervals[i].start >= intervals[prev].end)
                 prev = i;
            else
                cnt ++;
        }
            
        return cnt;
        
       
    }
    
    
}