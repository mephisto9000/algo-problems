package problem56;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Deque<int[]> deque = new LinkedList();
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[]a, int[]b) {
                return a[0]-b[0]!=0 ? a[0]-b[0] : b[0]-a[0];
            }
        });
        
        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            
            if (deque.size() > 0 && deque.peekLast()[1] >= tmp[0]) { 
                int last[] = deque.pollLast();
                tmp[0] = Math.min(last[0], tmp[0]);
                tmp[1] = Math.max(last[1], tmp[1]);
            }            
            deque.add(tmp);                
        }        
        int[][] ans = deque.toArray(new int[deque.size()][2]);
        return ans;
        
    }
}