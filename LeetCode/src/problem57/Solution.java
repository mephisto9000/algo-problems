package problem57;

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> ans = new LinkedList<Interval>();
        
        if (intervals == null || intervals.size() == 0)
        {
            if (newInterval!=null)
                ans.add(newInterval);
            return ans;
        }                
        
        for (Interval iti : intervals)
        {
            //if (iti.)
            if (newInterval!= null)
            {
                if (isIntersects(iti, newInterval))
                    newInterval = merge(newInterval, iti);
                else
                {
                    if (newInterval.start > iti.start)                        
                        ans.add(iti);
                    else
                    {
                        ans.add(newInterval);
                        ans.add(iti);
                        newInterval = null;
                    }
                }
            }
            else
                ans.add(iti);
            
        }
        
        if (newInterval != null)
            ans.add(newInterval);
        
        return ans;
        
        
    }
    
    boolean isIntersects(Interval a, Interval b)
    {
        if (a.start <= b.start)
        {
            if (a.end < b.start)
                return false;
            return true;
        }
        
         if (b.start <= a.start)
        {
            if (b.end < a.start)
                return false;
            return true;
        }
        
        return false;
    }
    
    Interval merge(Interval a, Interval b)
    {        
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));     
    }
}