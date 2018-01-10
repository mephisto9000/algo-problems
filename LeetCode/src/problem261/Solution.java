package problem261;

class Solution {
    
    int[] parent;
    
    int n;
    
    public boolean validTree(int n, int[][] edges) {
        this.n = n;
        initDSU(n+1);
        
        for (int i = 0; i < edges.length; i++)
        {
            if (union(edges[i][0], edges[i][1]) == -1)
                return false;                
        }        
        int p = findParent(0);
        for (int i = 1; i < n; i++)
        {
            if (findParent(i)!= p)
                return false;
        }
        
        return true;
    }
    
    void initDSU(int len)
    {
        parent = new int[len];
        
        for (int i = 0; i < len; i++)
            parent[i] = i;
    }
    
    int findParent(int idx)
    {
        if (parent[idx] == idx)
            return idx;
        else
            return findParent(parent[idx]);
    }
    
    int union(int idx1, int idx2)
    {
        int p1 = findParent(idx1);
        int p2 = findParent(idx2);
        
        if (p1 != p2)
        {
            parent[p1] = p2;
            return 0;
        }
        else
            return -1;
    }
    
    
}