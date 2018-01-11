package problem253;

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
    
    
    
    public int minMeetingRooms(Interval[] intervals) {
        
        Comparator<Interval> endCmp = new Comparator<Interval>() {          
           
            public int compare(Interval i1, Interval i2) { return i1.end - i2.end;}
        };
        
         Comparator<Interval> startCmp = new Comparator<Interval>() {          
           
            public int compare(Interval i1, Interval i2) { return i1.start - i2.start;}
        };
        
        int n = intervals.length;
        
        //PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, endCmp);
        
        PriorityQueue<Interval> starts = new PriorityQueue<Interval>(startCmp);
        
        PriorityQueue<Interval> ends = new PriorityQueue<Interval>(endCmp);
            
            
        for (int i = 0; i < intervals.length; i++)
            starts.add(intervals[i]);
        
        while(!starts.isEmpty())
        {
            Interval s = starts.poll();
            if (!ends.isEmpty()  && ends.peek().end <= s.start )
                ends.poll();
            
            ends.add(s);
        }
        
        return ends.size();
        
    }
}