package problem490;

class Solution {
    
    class Node
    {
        public int i;
        public int j;
        
        public Node(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
        
    }
    
    int maze[][];
    boolean visited[][];
    
    int w;
    int h;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        
        h = maze.length;
        w = maze[0].length;
        visited = new boolean[h][w];
        
        for (int i = 0; i < h; i++)
            Arrays.fill(visited[i], false);
        
        return bfs(start[0], start[1], destination[0], destination[1]);
    }
    
    boolean bfs(int si, int sj, int di, int dj)
    {
        if (si == di && sj == dj)
            return true;
        
        Queue<Node> q = new LinkedList();
        Node s = new Node(si, sj);
        visited[si][sj] = true;
        q.add(s);
                        
        while(!q.isEmpty())
        {
            Node tmp = q.poll();
            
            if (processDir(tmp.i, tmp.j, 1, 0, q, di, dj))
                return true;
            if (processDir(tmp.i, tmp.j, -1, 0, q, di, dj))
                return true;
            if (processDir(tmp.i, tmp.j, 0, -1, q, di, dj))
                return true;
            if (processDir(tmp.i, tmp.j, 0, 1, q, di, dj))
                return true;
        }
        
        return false;
    }
    
    boolean processDir(int ii, int jj, int ioffset, int joffset, Queue q, int di, int dj)
    {
        
        int i = ii;
        int j = jj;
        
         while(true)
            {                                
                if (i + ioffset >= h || i + ioffset < 0 || j + joffset >= w || j + joffset < 0 || maze[i+ioffset][j+joffset] == 1)
                {
                    if (i == di && j == dj)
                        return true;
                    
                    if (visited[i][j]!=true)
                    {
                        visited[i][j] = true;
                        Node x = new Node(i,j);
                        q.add(x);
                    }
                    break;
                }
             
              i += ioffset;
              j += joffset;
            }
        
        return false;
    }
}