package problem57;

class Solution {
    Stack<int[]> list;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        list = new Stack<>();
        int n = intervals.length;
        boolean used = false;
        
        if (intervals.length == 0)
            tryPush( newInterval);
        for (int i = 0; i < intervals.length; i++) {
            int[] a = intervals[i];
            int[] b = newInterval;
            
            //before first || before current
            if (a[0] > b[1] && used == false) {
                tryPush(b);
                tryPush(a);
                used = true;
            }
            else
            //after last    
            if (i == n-1 && a[1] < b[0]) {
                tryPush(a);
                tryPush(b);
                used = true;
            }
            else
            //merge    
            if (intersect(a,b)) {
                tryPush(merge(a,b));
                used = true;
            }
            else
            // no merge    
                tryPush(a);
            
        }
        
        
        
        return list.toArray(new int[0][2]);
        
    }
    
    int[] merge(int a[], int b[]) {
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1],b[1])};
    }
    
     
    boolean intersect(int[] a, int b[]) {
        return (a[0]<= b[0] && a[1]>=b[0]) || (a[0] <= b[1] && a[0] >= b[0]);
     }
    
    void tryPush(int b[]) {
        if (!list.isEmpty() && intersect(list.peek(), b)) {
            list.push(merge(list.pop(), b));
        } else
            list.push(b);
    }
}