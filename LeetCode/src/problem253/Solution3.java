package problem253;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[]a, int[]b) {
          return a[0]-b[0];
        }
      });
      
      Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[]a, int[]b) {
          return a[1]-b[1];          
        }
      } );
      int max = 0;
      for (int i = 0; i < intervals.length; i++) {
        while(!q.isEmpty() && q.peek()[1] <= intervals[i][0] )
          q.poll();
        q.add(intervals[i]);
        max = Math.max(max, q.size());
      }
      
      return max;
        
    }
}