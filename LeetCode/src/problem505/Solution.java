package problem505;

class Solution {
    
    int maze[][];
    boolean visited[][][];
    
    int UP = 0;
    int DOWN = 1;
    int LEFT = 2;
    int RIGHT = 3;
    
    
    class Node  {
        int x;
        int y;
        int dist;
        int dirX;
        int dirY;        
        
        public Node(int y, int x, int dirY, int dirX, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.dirX = dirX;
            this.dirY = dirY;
            
        }
        
        
    }
    
    int h;
    int w;
                 
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        h = maze.length;
        w = maze[0].length;
        
        this.maze = maze;
        visited  = new boolean[h][w][4];
                        
        return dfs(start[0], start[1], destination[0], destination[1]);        
    }
            
    int dfs(int y1, int x1, int y2, int x2)
    {
 
        Node src1 = new Node(y1, x1, -1, 0, 0);
        Node src2 = new Node(y1, x1, 1, 0, 0);
        Node src3 = new Node(y1, x1, 0, -1, 0);
        Node src4 = new Node(y1, x1, 0, 1, 0);
        visited[y1][x1][UP] = true;
        visited[y1][x1][DOWN] = true;
        visited[y1][x1][LEFT] = true;
        visited[y1][x1][RIGHT] = true;
        
        Queue<Node> q = new LinkedList();
        
        q.add(src1);
        q.add(src2);
        q.add(src3);
        q.add(src4);
        
        while (q.isEmpty() == false)
        {
            Node n = q.poll();
             
            if (isValid(n.y + n.dirY, n.x + n.dirX))
            {
                Node x = new Node(n.y + n.dirY, n.x + n.dirX, n.dirY, n.dirX, n.dist + 1);
                q.add(x);
            }
            else
            {     
                 if (n.y == y2 && n.x == x2)
                 return n.dist;
                
                  if (isValid(n.y-1, n.x)  && !visited[n.y-1][n.x][UP])
                  {
                     src1 = new Node(n.y-1, n.x, -1, 0, n.dist+1);
                     q.add(src1);
                     visited[n.y-1][n.x][UP] = true; 
                  }
                  if (isValid(n.y+1, n.x) && !visited[n.y+1][n.x][DOWN])
                  {
                      src1 = new Node(n.y+1, n.x, +1, 0, n.dist+1);
                      q.add(src1);
                      visited[n.y+1][n.x][DOWN] = true; 
                  }
                  if (isValid(n.y, n.x-1) && !visited[n.y][n.x-1][LEFT])
                  {
                      src1 = new Node(n.y, n.x-1, 0, -1, n.dist+1);   
                      q.add(src1);
                      visited[n.y][n.x-1][LEFT] = true; 
                  }
                  if (isValid(n.y, n.x+1) && !visited[n.y][n.x+1][RIGHT])
                  {
                      src1 = new Node(n.y, n.x+1, 0, 1, n.dist+1);   
                      q.add(src1);
                      visited[n.y][n.x+1][RIGHT] = true; 
                  }                  
                  
            }
            
        }
                   
        return -1;
    }
    
    boolean isValid(int y, int x)
    {
        if (x < 0 || y < 0 || x >= w || y >= h)
            return false;
        
        return maze[y][x] ==0 ? true : false;
    }
}