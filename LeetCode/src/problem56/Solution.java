package problem56;

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
     public int compare(Interval a, Interval b)
     {
          if (a.start < b.start)
              return -1;
           if (a.start > b.start)
               return 1;
           return 1;           
     }
    }
    
    
    public List<Interval> merge(List<Interval> intervals) {
        
        List<Interval> ans = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return ans;
        

        PriorityQueue pr = new PriorityQueue(intervals.size(),  new IntervalComparator());
        
        for (Interval i : intervals)
            pr.add(i);
        
        
        
        Interval prev = null;
        while(pr.size() > 0)
        {
            Interval curr = (Interval) pr.remove();
            
            if (prev != null)
            {
                if (prev.end >= curr.start)
                    curr = mergeSub(prev, curr);
                else                
                    ans.add(prev);                    
                
            }
            prev = curr;

        }

        ans.add(prev);
        
        return ans;

    }
    
    Interval mergeSub(Interval a, Interval b)
    {
        int l = Math.min(a.start, b.start);
        int r = Math.max(a.end, b.end);
        
        return new Interval(l, r);
    }
}