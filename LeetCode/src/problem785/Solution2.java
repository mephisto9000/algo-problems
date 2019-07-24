package problem785;

class Solution {
    
    int sides[];
    int graph[][];
    public boolean isBipartite(int[][] graph) {
                
        this.graph = graph;
        sides = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!rec(i,-1)) {
                return false;
            }
        }
        
        return true;       
    }
    
    boolean rec(int idx, int color) {
        
        
        
        if ((color > 0 && sides[idx] == color) || (color == -1 && sides[idx] != 0))
            return true;
        if (color > 1 && sides[idx]!= 0) {            
            return false;
        }
        
        if (color == -1)
            color = 1;
        
        sides[idx] = color;
        
        int nextColor = (color == 1)?2:1;
        boolean ans = true;
        for (int i = 0; i < graph[idx].length; i++)
            ans &= rec(graph[idx][i], nextColor);
        return ans;
    }
}