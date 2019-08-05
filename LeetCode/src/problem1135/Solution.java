package problem1135;

class Solution {
	  
    int parent[];
  
    void init(int n) {
      parent = new int[n+1];
      for (int i = 0; i <= n; i++)
        parent[i] = i;
    }
  
    int findParent(int idx) {
      if (idx == parent[idx]) {
        return idx;
      }
      else {
        return findParent(parent[idx]);
      }
    }
  
    int union(int idx1, int idx2, int price) {
      int p1 = findParent(idx1);
      int p2 = findParent(idx2);
      if (p1 != p2) {
        parent[p1] = p2;
        return price;
      }
      return 0;
    }
  
    public int minimumCost(int N, int[][] connections) {
        init(N);
        Arrays.sort(connections,  new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int [] b) {
            return (a[2]-b[2]);
          }
        });
      
      int min = 0;
      for (int i = 0; i < connections.length; i++) {
        int c[] = connections[i];
        min += union(c[0],c[1], c[2]);
      }
      
      Set<Integer> groups = new HashSet<>();
      for (int i = 1; i <= N; i++) {
        groups.add(findParent(i));
      }
           
      if (groups.size() >1)
        return -1;
      return min;
    }
}