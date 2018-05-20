package problem391;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    
    /*
    enum POINT_TYPE {
        TL, TR, BL, BR
    } */
    class Point {
        int x;
        int y;  
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return (31 * x) + y;
        }
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            
            return ((x == p.x) && (y == p.y));
        }
    }
    
    Map<Point, List<Integer>> map;
    
    public boolean isRectangleCover(int[][] rectangles) {
        int totalSize = 0;
        int minX, minY;
        minX = minY = Integer.MAX_VALUE;
        int maxX, maxY;
        maxX = maxY = Integer.MIN_VALUE;
        
        map = new HashMap();
        
        long totSize = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];
            
            
            minX = Integer.min(minX, x1);
            minY = Integer.min(minY, y1);
            maxX = Integer.max(maxX, x2);
            maxY = Integer.max(maxY, y2);
            
            totSize += (x2 - x1)*(y2-y1);
            
            Point p[] = new Point[4];
            p[0] = new Point(x1,y1);
            p[1] = new Point(x2,y1);
            p[2] = new Point(x1,y2);
            p[3] = new Point(x2, y2);
            for (int j = 0; j < 4; j++)
            if (map.containsKey(p[j])) {
                List<Integer> l = map.get(p[j]);
                if (l.contains(j))
                    return false;
                l.add(j);
            }
            else {
                List<Integer> l = new LinkedList();
                l.add(j);
                map.put(p[j], l);
            }
        }
                
                
        Point outer[] = new Point[4];
        outer[0] = new Point(minX, minY);
        outer[1] = new Point(minX, maxY);
        outer[2] = new Point(maxX, minY);
        outer[3] = new Point(maxX, maxY);
        
         for (Map.Entry<Point,List<Integer>> entry : map.entrySet()) {
             //if (map)
             Point pt = entry.getKey();
             List<Integer> l = entry.getValue();
             
             boolean skip = false;
             for (int i = 0; i < 4; i++)
                 if (pt.equals(outer[i]))
                     skip = true;
             
             if (!skip && l.size() % 2 > 0)
                 return false;
                 
         }
                     
        return ((maxY-minY)*(maxX - minX) == totSize );
         
    }
    
    Point makePoint(int x, int y, int type) {
        return new Point(x, y);
    }
}
}