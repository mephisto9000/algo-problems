package problem947;

class Solution {
    
    int parent[];
    boolean visited[];
    int n;
    Map<Integer, List<Integer>> colMap;
    Map<Integer, List<Integer>> rowMap;
    
    public int findParent(int idx) {
        if (parent[idx] == idx)
            return idx;
        else return findParent(parent[idx]);
    }
    
    public void initUnion(int n) {
        parent = new int[n+1];
        
        this.n = n;
        for (int i = 1; i <= n; i++) 
            parent[i] = i;
                
    }
    
    public int union(int idx1, int idx2) {
        int p1 = findParent(idx1);
        int p2 = findParent(idx2);
        
        if (p1 == p2)
            return p1;
        parent[p1] = p2;
        return p2;
    }
    
    public int removeStones(int[][] stones) {
        
        initUnion(stones.length);
        colMap = new HashMap<>();
        rowMap = new HashMap<>();
        visited = new boolean[n];
        
        for (int i = 0; i < stones.length; i++) {
            List<Integer> cols = colMap.getOrDefault(stones[i][0], new ArrayList<Integer>());
            List<Integer> rows = rowMap.getOrDefault(stones[i][1], new ArrayList<Integer>());
            cols.add(i);
            rows.add(i);
            colMap.put(stones[i][0], cols);
            rowMap.put(stones[i][1], rows);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
            while(!q.isEmpty()) {
                int stoneIdx = q.poll();
                
                union(i+1, stoneIdx+1);
                List<Integer> cols = colMap.get(stones[stoneIdx][0]);
                List<Integer> rows = rowMap.get(stones[stoneIdx][1]);
                                
                for (Integer colNeighbor: cols) {
                    if (!visited[colNeighbor]) {
                        q.add(colNeighbor);
                        visited[colNeighbor] = true;
                    }
                }
                for (Integer rowNeighbor: rows) {
                    if (!visited[rowNeighbor]) {
                        q.add(rowNeighbor);
                        visited[rowNeighbor] = true;
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i]!=i)
                count++;
        }
        return count;
        
    }
}