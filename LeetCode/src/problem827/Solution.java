package problem827;

class Solution {
    int w = 0;
    int h = 0;
   
    int grid[][];
    int islands[][];
    boolean visited[][];
    int lastIslandId= 1;
    Map<Integer, Integer> sizeMap;
    
    public int largestIsland(int[][] grid) {
        h = grid.length;
        w = grid[0].length;
        this.grid = grid;
        sizeMap = new HashMap();
        sizeMap.put(0,0);
        
        islands = new int[h][w];
        visited = new boolean[h][w];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                lastIslandId += markIslands(i, j, lastIslandId);        
        
        int maxSize = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                //System.out.println(sizeMap.get(islands[i][j]));
                maxSize =   Math.max(getSize(i,j, true), maxSize );
            }
        
        return maxSize;
    }
    
    int getSize(int i, int j, boolean bridge) {
         if (i<0 || j<0 || i>=h || j>=w )
            return 0;
        
        if (!bridge ) {
            return islands[i][j];
        }
        else {
            //return 1 + sizeIsland(i-1, j, false) + sizeIsland(i+1, j,false) + sizeIsland(i, j-1,false) + sizeIsland(i, j+1, false);
            Set<Integer> s = new HashSet();
            s.add(getSize(i-1,j, false));
            s.add(getSize(i+1,j, false));
            s.add(getSize(i,j-1, false));
            s.add(getSize(i,j+1, false));
            s.add(getSize(i,j, false));
            
            int sum = 1;
            if (grid[i][j] == 1)
                sum = 0;
            Iterator<Integer> it = s.iterator();
            while(it.hasNext()) {
                sum += sizeMap.get(it.next());
            }
            return sum;
        }
    }
    
    
    
    
    int markIslands(int i, int j, int lid) {
        if (i<0 || j<0 || i>=h || j>=w || visited[i][j] || grid[i][j] == 0 )
            return 0;
        
        visited[i][j] = true;
        if (sizeMap.containsKey(lid)) {
            int v = sizeMap.get(lid);
            sizeMap.put(lid, v+1);
        } else
        {
            sizeMap.put(lid, 1);
        }
        islands[i][j] = lid;
        
        markIslands(i-1,j, lid);
        markIslands(i+1,j, lid);
        markIslands(i,j-1, lid);
        markIslands(i,j+1, lid);   
        return 1;
    }
    
    
}