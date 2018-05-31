package problem373;

class Solution {
    
    class Pair  {        
        int x = -1;
        int y = -1;        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;            
        }               
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
       List<int[]> ans = new LinkedList();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return ans;
                                         
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                 return -(p1.x+p1.y) + (p2.x + p2.y);   
            }
        });
                                
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++) {
                
                Pair p = new Pair(nums1[i], nums2[j]);
                
                if (pq.size() < k)
                    pq.add(p);
                else {
                    Pair h = pq.peek();
                    
                    if (h.x + h.y > p.x + p.y) {
                        pq.poll();
                        pq.add(p);
                    }
                }
                    
            }    
        
        
        while( pq.size() > 0) {
            int[] t = new int[2];
            
            Pair p = pq.poll();
            t[0]= p.x;
            t[1] = p.y;
             
            ans.add(t);          
        }
        
        return ans;                
    }
}