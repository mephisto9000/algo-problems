package problem785;

class Solution {
    
     
    
    
    Map<Integer, List<Integer>> graphMap;
    List<Integer> colors;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        graphMap = new HashMap();
        colors = new ArrayList();
        for (int i = 0; i < n; i++) {  
            List<Integer> l = graphMap.get(i);
            
            if (l == null) {
                l = new LinkedList();
                graphMap.put(i, l);
                colors.add(0);
            }
            for (int j =0; j < graph[i].length; j++) {
                l.add(graph[i][j]);                
            }
        }
        
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet();
        
        for (int i = 0; i < n; i++) {
            
        if (visited.contains(i))
            continue;
            
        q.add(i);
        colors.set(i,1);
        visited.add(i);    
        
        
        
        
        while(q.size() > 0) {
            int idx = q.poll();
            
            List<Integer> l = graphMap.get(idx);
            int col = colors.get(idx);
            
            for (Integer lx : l) {
                
                if (colors.get(lx) == col)
                    return false;
                
                if (visited.contains(lx))
                    continue;
                
                visited.add(lx);
                colors.set(lx, -col);
                q.add(lx);
            }
        }
            
        }
        
        return true;
        
            
    }    
}