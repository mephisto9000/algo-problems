package problem286;

class Solution {
    
    int w;
    int h;
    int grid[][];
    
    final int INF = 2147483647;
    
    class Pair
    {
        public int i;
        public int j;
        
        public int pi;
        public int pj;
        
        public int dist;
        
        public Pair(int i, int j, int dist, int pi, int pj)
        {
            this.i = i;
            this.j = j;
            this.pi = pi;
            this.pj = pj;
            this.dist = dist;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        
        grid = rooms;
        h = grid.length;
        w = grid[0].length;
               
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
            {
                if (grid[i][j] == 0)
                    bfs(i,j);
            }
        
    }
    
    int bfs(int i, int j)
    {
        boolean visited[][] = new boolean[h][w];
                       
        Queue<Pair> q = new LinkedList();
        visited[i][j] = true;
        
        Pair srcp = new Pair(i,j, 0,i,j);
        q.add(srcp);
                
        int dist = 0;
                       
        while(!q.isEmpty())
        {
            Pair p = q.poll();
                        
            dist = Math.max(dist,  enqueue(q, visited, p, 1, 0));
            dist = Math.max(dist,  enqueue(q, visited,  p, -1, 0));
            dist = Math.max(dist,  enqueue(q, visited,  p, 0, 1));
            dist = Math.max(dist,  enqueue(q, visited,  p, 0, -1));
            
            if (dist > 0)
            {                
                break;  
            }
            
        }
        
        if (dist == 0)
            dist = INF;                                      
        return dist;
    }
    
    int enqueue(Queue<Pair> q, boolean visited[][],  Pair p, int i_offs, int j_offs)
    {
        if (p.i + i_offs >=0 && p.i + i_offs < h && p.j + j_offs >= 0 && p.j + j_offs < w && !visited[p.i + i_offs][p.j + j_offs])
        { 
            visited[p.i + i_offs][p.j + j_offs] = true;
            
            if (grid[p.i + i_offs][p.j + j_offs] != 0 && grid[p.i + i_offs][p.j + j_offs] != -1)
            {
                if (grid[p.i + i_offs][p.j + j_offs] > grid[p.i][p.j] +1)
                {
                    grid[p.i + i_offs][p.j + j_offs] = grid[p.i][p.j] +1;
                    Pair tmp =  new Pair(p.i + i_offs, p.j + j_offs, p.dist + 1, p.pi, p.pj);
                    q.add(tmp);
                }                
            }
        }
        
        return 0;                        
    }
    
}