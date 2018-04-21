package problem797;


import java.util.*;
class Solution {
    
    boolean mtx[][];
    int n;
    List<List<Integer>> ans;
        
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        mtx = new boolean[n][n];
        
        for (int i = 0; i < n; i++)       
            for (int j = 0; j < graph[i].length; j++) 
                mtx[i][graph[i][j]] = true;
        
        Deque<Integer> dq = new LinkedList<>();
        ans = new LinkedList();
        dfs(0, dq);    
        return ans;
                    
    }
    
    void dfs(int i,  Deque <Integer> dq) {
        
         dq.add(i);
        
        if (i == n-1)
            ans.add(new LinkedList(dq));
 
        for (int j = 0; j < n; j++) {
            if (mtx[i][j])
                dfs(j, dq);
        }
        
        dq.removeLast();
    }
    
    
}