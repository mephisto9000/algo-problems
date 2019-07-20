package problem973;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
                
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int []b) {
                return -(a[0]*a[0]+a[1]*a[1]) + (b[0]*b[0] + b[1]*b[1]);
            }
        });
        
        for (int i = 0 ; i < points.length; i++) {
            int p[] = points[i];
            
            heap.add(p);
            
            if (heap.size() > K)
                heap.poll();
        }
        
        int ans[][] = heap.toArray(new int[heap.size()][2]);
        return ans;
        
    }
}