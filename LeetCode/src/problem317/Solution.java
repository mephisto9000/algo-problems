package problem317;

class Solution {
    int w;
    int h;
    
    int grid[][];
    
    int houses = 0;
    
    class Pair{
        public int i;
        public int j;
        public int dist = 0;
        
        public Pair(int i, int j, int dist)
        {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        
        this.grid = grid;
        
        h = grid.length;
        w = grid[0].length;
        
        for(int i = 0; i < h; i++)
           for(int j = 0; j < w; j++)
               if (grid[i][j] == 1)
                   houses ++;
        
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < h; i++)
           for(int j = 0; j < w; j++)
           {
               min = Math.min(min, dfs(i,j));
           }
        
        
        if (min == Integer.MAX_VALUE)
            min = -1;
        return min;
    }
    
    int dfs(int i, int j)
    {
        if (grid[i][j]!=0)
            return Integer.MAX_VALUE;
        
        boolean visited[][] = new boolean[h][w];
        for (int z = 0; z < h; z++)
            Arrays.fill(visited[z], false);
                        
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(i,j, 0));
        visited[i][j] = true;
        
        int sum = 0;
        int sumPrev = 0;
        int housesLocal = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
             
           // sumPrev = sum;
            sum = enqueue(visited, q, -1, 0, p, sum);
            if (sumPrev != sum)
                housesLocal ++;
            sumPrev = sum;
            sum = enqueue(visited, q, 1, 0, p, sum);
            if (sumPrev != sum)
                housesLocal ++;
            sumPrev = sum;
            sum = enqueue(visited, q, 0, -1, p, sum);
            if (sumPrev != sum)
                housesLocal ++;
            sumPrev = sum;
            sum = enqueue(visited, q, 0, 1, p, sum);
            if (sumPrev != sum)
                housesLocal ++;
            sumPrev = sum;
            
           
            
           
        }
        
        if (sum == 0 || housesLocal < houses)
            return Integer.MAX_VALUE;
        
        
        return sum;
    }
    
    int enqueue(boolean[][] visited, Queue q, int i_offs, int j_offs, Pair p, int sum)
    {
        if ( p.i + i_offs >= 0 && p.i + i_offs < h && p.j + j_offs >= 0 && p.j + j_offs < w)
            {
                if (!visited[p.i+i_offs][p.j+j_offs])
                {
                    if (grid[p.i+i_offs][p.j+j_offs] == 0)
                    {
                        q.add(new Pair(p.i+i_offs, p.j+j_offs, p.dist + 1));
                    }
                    
                    if (grid[p.i+i_offs][p.j+j_offs] == 1)
                    {
                        sum += p.dist+1;
                    }
                    visited[p.i+i_offs][p.j+j_offs] = true;
                }
            }
        
        
        return sum;
    }
    
}