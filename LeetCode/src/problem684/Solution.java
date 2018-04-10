package problem684;

class Solution {
    
    
    int parent[];
    void initDsu(int len) {
        parent = new int[len + 1];
        for (int i = 0; i < len + 1; i++)
            parent[i] = i;
    }
    
    int findParent(int idx)
    {
        if (parent[idx] == idx)
            return idx;
        else
            return findParent(parent[idx]);
    }
    
    int union(int idx1, int idx2) {
        int p1 = findParent(idx1);
        int p2 = findParent(idx2);
        
        if (p1 == p2)
            return -1;
        
        parent[p1] = p2;
        return 0;
    }
        
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        initDsu(n);
                
        for (int i = 0; i < n; i++) {        
            if (union(edges[i][0], edges[i][1]) == -1)
                return edges[i];
        }
        
        return null;
        
    }
}