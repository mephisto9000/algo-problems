package problem305;

class Solution {
    
    
    int parent[];
    int grid[][];
    
    int w;
    int h;
    
    public void initDSU(int len)
    {
        parent = new int[len];
        
        for (int i = 0; i < len; i++)
        {
            parent[i] = i;
        }
    }
    
    public int getParent(int idx)
    {
        if (parent[idx] == idx)
            return idx;
        else
            return getParent(parent[idx]);
    }
    
    public int union(int idx1, int idx2)
    {
        int p1 = getParent(idx1);
        int p2 = getParent(idx2);
        
        if (p1 == p2)
            return p1;
        
        parent[p1] = p2;
        return p2;        
    }
    
    public int addLand(int i, int j)
    {
        int sIdx = getIdx(i, j);
        int parentIdx = getParent(sIdx);
        int idx = getIdx(i-1, j);
        int ans = 1;
        
        if (validLand(i-1,j) && grid[i-1][j]==1 && getParent(idx) != parentIdx)
        {
            union(sIdx, idx);
            parentIdx = getParent(sIdx);
            ans --;
        }
        
        idx = getIdx(i+1, j);
        if (validLand(i+1,j) && grid[i+1][j]==1 && getParent(idx) != parentIdx)
        {
            union(sIdx, idx);
            parentIdx = getParent(sIdx);
            ans --;
        }
        
        idx = getIdx(i, j-1);
        if (validLand(i,j-1) && grid[i][j-1]==1 && getParent(idx) != parentIdx)
        {
            union(sIdx, idx);
            parentIdx = getParent(sIdx);
            ans --;
        }
        
        
        idx = getIdx(i, j+1);
        if (validLand(i,j+1) && grid[i][j+1]==1 && getParent(idx) != parentIdx)
        {
            union(sIdx, idx);
            //parentIdx = getParent(sIdx);
            ans --;
        }
        
        return ans;
        
    }
    
    int getIdx(int i, int j)
    {
        return w * i + j;
    }
    
    public boolean validLand(int i, int j)
    {
        if (i >= 0 && i < h && j >= 0 && j < w)
            return true;
        return false;
    }
    
    
        
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        grid = new int[m][n];
        
        h = m;
        w = n;
        
        initDSU(m * n);
        
        List<Integer> ans = new LinkedList();
        int tot = 0;
        for (int i = 0; i < positions.length; i++)
        {
            grid[positions[i][0]][positions[i][1]] = 1;
            
            tot += addLand(positions[i][0],positions[i][1]);
            ans.add(tot);
        }
                    
        return ans;                    
        
    }
}