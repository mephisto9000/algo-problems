package problem218;

class Solution {
    
    public List<int[]> getSkyline(int[][] buildings) { 
        
        List<int[]> ans = new LinkedList();
        if (buildings.length == 0)
            return ans;
         
         PriorityQueue<int[]> hq = new PriorityQueue(buildings.length*2, new Comparator<int[]>() {
             @Override
             public int compare(int[] a, int[] b) {
                 return a[0] - b[0];
             }
         });
         
         for (int i = 0; i < buildings.length; i++) {
             int[] start = new int[]{ buildings[i][0], buildings[i][2]};
             //markings end of the interval with negative height
             int[] end = new int[] { buildings[i][1], -buildings[i][2]};
             hq.add(start);
             hq.add(end);
        }

         TreeMap<Integer,Integer> hs = new TreeMap();
                  
         while(hq.size() > 0) {
             int[] point = hq.poll();
             
             if (point[1] > 0 ) {
                 //going up
                 if (hs.size() == 0 || hs.lastKey() < point[1]) {                     
                    hs.put(point[1], hs.getOrDefault(point[1],0)+1); 
                     
                    ans.add(point);
                 } else {
                 //caching interval    
                     hs.put(point[1], hs.getOrDefault(point[1],0)+1); 
                 }
             }
                          
             if (point[1] < 0)  {
                 //going down
                 if (hs.lastKey()==-point[1]) {          
                     if (hs.get(-point[1])==1) {
                         hs.remove(-point[1]);
                         ans.add(new int[]{point[0], hs.size()> 0 ? hs.lastKey() : 0});   
                     }
                     else {
                         hs.put(-point[1], hs.get(-point[1])-1);
                                       
                     }
                    
                 }
                 else {
                    // removing interval 
                    if (hs.get(-point[1])==1)
                         hs.remove(-point[1]);
                     else
                         hs.put(-point[1], hs.get(-point[1])-1);
                 }
               }
             }
                
        // lets remove connected points
         for (int i = 0; i < ans.size()-1; i++) {
             int curDown[] = ans.get(i);
             int nextUp[] = ans.get(i+1);
             
             if (curDown[0]==nextUp[0]) {
                 ans.remove(i);
                 if (i > 0 && ans.get(i-1)[1]== nextUp[1]) {
                    ans.remove(i);
                     
                 }
                 i--;
             }
                 
         } 
                                                 
         return ans;                        
    }
            
}