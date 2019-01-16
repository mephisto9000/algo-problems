package problem909;

class Solution {
    boolean visited[];
    int nmax;
    Map<Integer, Integer> keys;
    
    public int snakesAndLadders(int[][] board) {        
        int n = board.length;
        nmax = n*n;
        keys = new HashMap();
        visited = new boolean[n*n];        
        boolean right = true;
        int z = 1;
        
        for (int i = n-1; i >= 0; i--) {
            if (right) {
                for (int j = 0; j < n; j++) {
                    keys.put(z, board[i][j]);
                    z++;
                }
            } else {
                for (int j = n-1; j >=0; j--) {
                    keys.put(z, board[i][j]);
                    z++;
                }
            }
            right = !right;            
        }
        
        Queue<Integer> positions = new LinkedList();
        Queue<Integer> dists = new LinkedList();
        positions.add(1);
        dists.add(0);
        visited[0] = true;
        while(!positions.isEmpty()) {
            int pos = positions.poll();
            int dist = dists.poll();                                                            
            for (int i = 1; i <= 6; i++) {
                int x = 0;
                if (pos + i == nmax)
                    return dist + 1;
                x = pos+i;                                
                if (x < nmax && visited[x])
                    continue;
                visited[x] = true;
                x = keys.get(x);
                if (x < 0)
                    x = pos + i;                
                if (x == nmax)
                    return dist + 1;                
                positions.add(x);                      
                dists.add(dist+1);                 
            }
        }
        return -1;
    }
    
    
}