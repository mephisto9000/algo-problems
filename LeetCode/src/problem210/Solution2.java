package problem210;

class Solution {
    boolean used[];
    Map<Integer, List<Integer>> preq;
    Set<Integer> usedSet;
  
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;
        used = new boolean[n];
        preq = new HashMap<>();
        usedSet = new HashSet<>();
                
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> l = preq.getOrDefault(prerequisites[i][0], new LinkedList<Integer>());
            l.add(prerequisites[i][1]);
            preq.put(prerequisites[i][0], l);
        }
        
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (topSort(prerequisites[i][0], ans) == false)
                return new int[0];
        }

        for (int i = 0; i < n; i++) {
            if (!usedSet.contains(i))
                ans.add(i);
        }

        int[] arr = new int[ans.size()];
        usedSet.clear();
        for (int i = 0; i < ans.size(); i++) {
          if (usedSet.contains(ans.get(i)))
            continue;
            
            arr[i] = ans.get(i);
            usedSet.add(arr[i]);
        }
        
        return arr;
                
    }
    
    
    boolean topSort(int idx, List<Integer> ans) {
        if (used[idx])
            return false;
        used[idx] = true;
       usedSet.add(idx);
        
        List<Integer> l = preq.getOrDefault(idx, new LinkedList());
        for (Integer pidx : l) {
            if (topSort(pidx, ans)==false)
                return false;
        }
        
       //if (!ans.contains(idx))
        ans.add(idx);
        used[idx] = false;
        return true;
    }
}