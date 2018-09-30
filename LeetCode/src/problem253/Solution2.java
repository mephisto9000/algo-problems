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
class Solution2 {
    public int minMeetingRooms(Interval[] intervals) {
        
    Arrays.sort(intervals, new Comparator<Interval>() {
       @Override
        public int compare(Interval a, Interval b) {
            return a.start != b.start ? a.start - b.start : b.end - a.end;
        }
    });
    
     
    PriorityQueue<Interval> pq = new PriorityQueue(new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.end - b.end; // //a.end != b.end ? a.start - b.start : b.end - a.end;
        }
    });
    int max = 0;
    for (int i = 0; i < intervals.length; i++) {
        
        System.out.println(intervals[i].start+" "+intervals[i].end);
        while(!pq.isEmpty() && pq.peek().end <= intervals[i].start) {
            pq.poll();
        }
        pq.add(intervals[i]);
        max = Math.max(max, pq.size());
    }
                        
    return max;
    }
}