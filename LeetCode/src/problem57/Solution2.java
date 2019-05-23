package problem57;

class Solution {            
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];                    
            }
        });
        
        for (int i = 0; i < intervals.length; i++) {
            pq.add(intervals[i]);            
        }
        pq.add(newInterval);
        
        List<int[]> l = new ArrayList<>();
        int[] last = null;
        
        while(!pq.isEmpty()) {
            if (last == null)
                last = pq.poll();
            else {
                int tmp[] = pq.poll();
                if (intersect(tmp, last))
                    tmp = merge(last, tmp);
                else
                    l.add(last);
                last = tmp;
            }
                
        }
        
        l.add(last);
        
        return l.toArray(new int[0][2]);
    }
    
    int[] merge(int a[], int b[]) {
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1],b[1])};
    }
    
    boolean intersect(int[] a, int b[]) {
        return (a[0]<= b[0] && a[1]>=b[0]) || (a[0] <= b[1] && a[0] >= b[0]);
     }
}