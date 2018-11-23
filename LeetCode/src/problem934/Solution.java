package problem934;

class Solution {
    int mtx[][];
    int h = -1;
    int w = -1;    
    int dst[][];
    public int shortestBridge(int[][] A) {        
       mtx = A;        
       h = mtx.length;
       w = mtx[0].length;
       dst = new int[h][w];          
       Queue<int[]> q = new LinkedList(); 
        for (int i = 0; i < A.length; i++) {
            boolean flag = false;
            for (int j = 0; j < A[0].length; j++)
                if (A[i][j]==1) {
                    q = markFirst(i,j,q);
                    flag = true;
                    break;
                }
            
            if (flag == true)
                break;
        }        
        return bfs(q);
    }
    
    int bfs(Queue<int[]> q) {
        while(!q.isEmpty()) {            
            int[] point = q.poll();
            int cur_dist = dst[point[0]][ point[1]];
            
            if (mtx[point[0]][point[1]]==1)
                return cur_dist-1;
            
            if (testPoint(point[0]-1, point[1])) {
                int[] next = new int[] {point[0]-1, point[1]};
                q.add(next);
                dst[point[0]-1][point[1]] = cur_dist+1;
            }
                
            if (testPoint(point[0]+1, point[1])) {
                int[] next = new int[] {point[0]+1, point[1]};
                q.add(next);
                dst[point[0]+1][point[1]] = cur_dist+1;
            }
            
            if (testPoint(point[0], point[1]-1)) {
                int[] next = new int[] {point[0], point[1]-1};
                q.add(next);
                dst[point[0]][point[1]-1] = cur_dist+1;
            }
            
            if (testPoint(point[0], point[1]+1)) {
                int[] next = new int[] {point[0], point[1]+1};
                q.add(next);
                dst[point[0]][point[1]+1] = cur_dist+1;
            }
                                            
        }
        
        return -1;
    }
    
    boolean testPoint(int y, int x) {
        if (y < 0 || y >= h || x < 0 || x >= w || (mtx[y][x]!=1 && mtx[y][x]!=0) || dst[y][x]!=0)
            return false;
        return true;
    }
    
    Queue<int[]> markFirst(int y, int x, Queue<int[]> q) {
        if (y < 0 || y >= h || x < 0 || x >= w || mtx[y][x]!=1)
            return q;
                
        mtx[y][x] = Integer.MIN_VALUE;
        q.add(new int[]{y,x});
        markFirst(y-1,x,q);
        markFirst(y+1,x,q);
        markFirst(y,x-1,q);
        markFirst(y,x+1,q);
        return q;        
    }
}