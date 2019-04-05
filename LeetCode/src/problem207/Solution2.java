package problem207;

class Solution {
    
    List<Integer> courseOrder;
    boolean used[];
    int g[][];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courseOrder = new ArrayList();
        
    int[] courseData = new int[numCourses];
    g = new int[numCourses][numCourses];
        
    for (int i = 0; i < prerequisites.length; i++) {
        //g[]    
        int k1 = prerequisites[i][0];
        int k2 = prerequisites[i][1];
        
        g[k1][k2] = 1;
    }
        
    topSort(numCourses);
    Set<Integer> usedCourses = new HashSet<>();
    for (int i = 0; i < courseOrder.size(); i++) {
        int c = courseOrder.get(i);
        for (int j = 0; j < numCourses; j++) {
            int v = g[c][j];
            if (v > 0 && usedCourses.contains(j))
                return false;
        }
        usedCourses.add(c);        
    }
        
    return true;    
    }
    
    
    void dfs(int v) {
        used[v] = true;
        for (int i = 0; i < g[v].length; i++) {
            if (g[v][i]>0 && !used[i])
                dfs(i);            
        }
        courseOrder.add(v);
        
    }
    
    void topSort(int n) {
        used = new boolean[n];
        
        for (int i = 0; i <n; i++)
            if (!used[i])
                dfs(i);
        Collections.reverse(courseOrder);
    }
    
    
}