package problem759;

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
    
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start == b.start) 
                return a.end - b.end;
            return a.start - b.start;
        }                
    }
    
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue(new IntervalComparator());
        
        for (List<Interval> personShifts : schedule) {
            for (Interval shift : personShifts)
                pq.add(shift);
        }
                
        Interval last = null;
        List<Interval> ans = new LinkedList();
        while(!pq.isEmpty()) {
            Interval frame = pq.poll();
            if (last == null)
                last = frame;
            else {
                if (last.end < frame.start) {
                    ans.add(new Interval(last.end, frame.start));
                    last = frame;
                } else
                    last.end = Math.max(last.end, frame.end);
            }
        }
        return ans;                
    }
}