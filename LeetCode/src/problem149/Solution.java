package problem149;

class Solution {
    
    public class Pair {
      int x;
      int y;
      public Pair(int x, int y) {
        this.x = x;
        this.y = y;
      }
        
      @Override
      public int hashCode() {
        return 117*x+y;
      }
      
      public boolean equals(Object o) {
        Pair op = (Pair) o;
        
        if (x == op.x && y == op.y)
          return true;
        return false;
      }
    }
  
    public int maxPoints(int[][] points) {
        
      if (points == null)
        return 0;
      
      int n = points.length;
      if (n <= 2)
        return n;
      
      Map<Pair, Integer> map = new HashMap<>();
      int ans = 0;
      for (int i = 0; i < n; i++) {
        map.clear();
        int overlap = 0;
        int max = 1;
        for (int j = i+1; j < n; j++) {
          int x = points[j][0] - points[i][0];
          int y = points[j][1] - points[i][1];
          
          if (x==0 && y == 0) {
            overlap++;
            continue;
          }
          
          int gcdVal = gcd(x,y);
          if (gcdVal != 0) {
            x/=gcdVal;
            y/=gcdVal;
          }
          
          Pair p = new Pair(x,y);
 
          int v = map.getOrDefault(p, 1);
          map.put(p,v+1);
          max = Math.max(max, v+1);
          
        }
        
        ans = Math.max(ans, max + overlap);
      }
      return ans;
    }
  
  private int gcd(int a, int b) {
    if (b == 0)
      return a;
    else
      return gcd(b, a%b);
  }
}