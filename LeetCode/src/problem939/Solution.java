package problem939;

class Solution {
    
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }        
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return x==p.x && y == p.y;
        }
        
        @Override
        public int hashCode() {
            return 117*x + y;
        }
    }
    
    Set<Point> uniPoints;
    
    public int minAreaRect(int[][] points) {
        
        uniPoints = new HashSet<>();
        
        for (int i = 0; i < points.length; i++) {
            uniPoints.add(new Point(points[i][0], points[i][1]));
        }
        
        int minArea = Integer.MAX_VALUE;
        
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Point derived1 = new Point(points[i][0], points[j][1]);
                Point derived2 = new Point(points[j][0], points[i][1]);
                if (uniPoints.contains(derived1) && uniPoints.contains(derived2)) {
                    int tmpArea = (points[i][0]-points[j][0])*(points[i][1]-points[j][1]);
                    
                    if (tmpArea == 0)
                        continue;
                    
                    tmpArea *= (int) Math.signum(tmpArea);
                    
                    minArea = Math.min(minArea, tmpArea);
                }
            }
        }
                          
        if (minArea == Integer.MAX_VALUE)
            return 0;
                          
        return minArea;
        
    }
}