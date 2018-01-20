package problem323;

class Solution {
    
    int parent[];
    int n;
    
    public int findParent(int idx)
    {
        if (parent[idx] == idx)    
            return idx;
        else
            return findParent(parent[idx]);
    }
    
    public void initBST(int n)
    {
        this.n = n;
        parent = new int[n];
        
        for (int i =0; i < n; i++)        
            parent[i] = i;        
        return;
    }  
    
    public void union(int idx1, int idx2)
    {
        int p1 = findParent(idx1);
        int p2 = findParent(idx2);
        
        if (p1 != p2)
            parent[p1] = p2;
        return;
    }
    
    public int countComponents(int n, int[][] edges) {
           
        initBST(n);
        
        for (int i = 0; i < edges.length; i++)
        {
            int idx1 = edges[i][0];
            int idx2 = edges[i][1];
            
            union(idx1, idx2);
        }
        
        int hits[] = new int[n];        
        
        for (int i = 0; i < n; i++)
        {
            int p = findParent(i);            
            
            hits[p] += 1;
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            if (hits[i] > 0)
                ans ++;
        }
        
        return ans;
    }
}