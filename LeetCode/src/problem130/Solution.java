package problem130;

class Solution {
    
    int w;
    int h;
    char mtx[][];
    int visited[][];
    //int visited2[][];
    
    int parent[];
    
    boolean isOccupied[];
    
    int pn;
    
    
    public int coordToNum(int i, int j)
    {
        int v = w*i + j+1;
        
        if(i==0 || i == h-1 || j ==0 || j == w-1)
            isOccupied[v] = true;
        
        return v;
    }
    
    public int find(int x)
    {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
    
    public void union(int x, int y)
    {
        int px = x;
        int py = y;
        
        boolean occupied = false;        
        
        occupied = occupied || isOccupied[x];
        occupied = occupied || isOccupied[y];
            
        
        if (parent[x]!=px)
            px = find(px);
        
        if (parent[y]!=py)
            py = find(py);
        
        occupied = occupied || isOccupied[px];
        occupied = occupied || isOccupied[py];
        
        if (px!=py)
        {
            parent[py] = px;
            isOccupied[px] = occupied;
        }
    }
    
    public void solve(char[][] board) {
    
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        
        h = board.length;
        w = board[0].length;
        mtx = board;
        
        visited =  new int[h][w];
       // visited2 = new int [h][w];
        
        for (int i = 0; i < h; i++)
        {
            Arrays.fill(visited[i], -1);
           // Arrays.fill(visited2[i], -1);
        }
        
        pn = h*w;
        
        parent = new int[pn+1];
        isOccupied  = new boolean[pn+1];
        
        Arrays.fill(isOccupied, false);
        
        for (int i = 0; i <= pn; i++)
            parent[i] = i;
        
        
        
        
        
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
               
                unify(i,j);
                
                
            }
        
         for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
             
                tryFill(i,j);
               
            }
        
        
    }
    
    void tryFill(int i,int j)
    {
        //if (find())
        int idx = coordToNum(i,j);
        
        int pidx = find(idx);
        
        if (!isOccupied[pidx])
             mtx[i][j] = 'X';
    }
    
    boolean compatible(int i, int j, int i1, int j1)
    {
        if (i < 0 || j < 0 || j >= w || i >= h)
            return false;
        
        if (i1 < 0 || j1 <0 || j1 >= w || i1 >= h)
            return false;
        
        if (mtx[i][j]=='O' && mtx[i1][j1]=='O')
        {
            return true;
        }
        
        return false;
        
    }
    
    boolean unify(int i, int j)
    {
        if (i < 0 || j < 0 || j >= w || i >= h)
            return false;
        
        if (mtx[i][j] == 'X')
            return true;
        
       
        /*
        if (visited[i][j]!=-1)
        {
            if (visited[i][j] == 1)
                return true;
            else
                return false;
        } */
        
        boolean ans = true;
        
        //so we won't bump into it again
        visited[i][j] = 1;
        
        
 
        if (compatible(i,j,i-1,j))
            union(coordToNum(i,j), coordToNum(i-1,j));
            
 
         if (compatible(i,j,i,j-1))
            union(coordToNum(i,j), coordToNum(i,j-1))   ;
        
 
             if (compatible(i,j,i+1,j))
            union(coordToNum(i,j), coordToNum(i+1,j))   ;
        
 
                 if (compatible(i,j,i,j+1))
            union(coordToNum(i,j), coordToNum(i,j+1))   ;
        
 
       /* 
        if (ans)
            visited[i][j] = 1;
        else
            visited[i][j] = 0; */
        
        return ans;
    }
    
   
    
}