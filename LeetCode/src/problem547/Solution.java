package problem547;

class Solution {
    
    
    int n;
    int parents[];
    
    void initDSU(int len)
    {
        parents = new int[len];
        for (int i = 0; i <= n; i++)
        {
            parents[i] = i;
        }
        
    }
    
    
    int findParent(int idx)
    {
        if (parents[idx] == idx)
            return idx;
        else
            return (findParent(parents[idx]));
    }
    
    void union(int idx1, int idx2)
    {
        int p1 = findParent(idx1);
        int p2 = findParent(idx2);
        
        if (p1 == p2)
            return;
        
        parents[p1] = p2;
    }
    
    public int findCircleNum(int[][] M) {
        
        n = M.length;
        initDSU(n+1);
        
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
            {
                if (M[i][j] == 1)
                    union(i, j);
            }
        
        Set<Integer> circles = new HashSet();
        
        for (int i = 0; i < n; i++)
        {
 
            circles.add(findParent(i));
        }
        
        return circles.size();
        
        
    }
}