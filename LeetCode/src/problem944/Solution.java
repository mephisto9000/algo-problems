package problem944;

class Solution {
    
    
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int fresh = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2)
                    q.add(new int[]{i,j});
                if (grid[i][j]==1)
                    fresh++;
            }
        
        int time = 0;
        while (q.size()>0) {
            Queue<int[]> tmpQ = new LinkedList<>();
                        
            while(q.size() > 0) {
                int[] rot = q.poll();
                
                
                if (isAvailable(new int[]{rot[0]-1, rot[1]}, grid) && grid[rot[0]-1][rot[1]]==1) {
                    tmpQ.add(new int[]{rot[0]-1, rot[1]});
                    grid[rot[0]-1][rot[1]]=2;
                    fresh--;
                }
                if (isAvailable(new int[]{rot[0]+1, rot[1]}, grid) && grid[rot[0]+1][rot[1]]==1) {
                    tmpQ.add(new int[]{rot[0]+1, rot[1]});
                    grid[rot[0]+1][rot[1]]=2;
                    fresh--;
                }
                if (isAvailable(new int[]{rot[0], rot[1]-1}, grid) && grid[rot[0]][rot[1]-1]==1) {
                    tmpQ.add(new int[]{rot[0], rot[1]-1});
                    grid[rot[0]][rot[1]-1]=2;
                    fresh--;
                }
                if (isAvailable(new int[]{rot[0], rot[1]+1}, grid) && grid[rot[0]][rot[1]+1]==1) {
                    tmpQ.add(new int[]{rot[0], rot[1]+1});                
                    grid[rot[0]][rot[1]+1]=2;
                    fresh--;
                }
            }
            time++;
            
            q = tmpQ;
        }
        
        if (fresh > 0)
            return -1;
        return time> 0?time-1:0;
                
    }
    
    boolean isAvailable(int[] location, int[][] grid) {
        if (location[0] < 0 || location[0] >= grid.length || location[1] < 0 || location[1] >= grid[0].length)
            return false;
        return true;
            
    }
}