package problem252;

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
    
    class IntervalComparator  implements Comparator<Interval>
    {
         @Override
          public int compare(Interval obj1, Interval obj2)
          {
              Interval o1 = obj1; //(Interval) obj1;
              Interval o2 = obj2; //(Interval) obj2;
              if (o1.start < o2.start)
                  return -1;
               if (o1.start > o2.start)
                   return 1;
              if (o1.end > o2.end)
                  return -1;
              if (o1.end < o2.end)
                  return 1;
              
              return 0;
          }
    }
    
    public boolean canAttendMeetings(Interval[] intervals) {
        
    Comparator<Interval> comparator = new IntervalComparator();
     
    PriorityQueue<Interval> pq = new PriorityQueue<Interval>(10000, comparator);
    
    for (int i = 0; i < intervals.length; i++)
        pq.add(intervals[i]);
    
    Interval prev = new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
    while(!pq.isEmpty())
    {
        Interval tmp = pq.poll(); //(Interval) 
        
        if (prev.end > tmp.start)
            return false;
        
        prev = tmp;
    }
    
    return true;
    }
}