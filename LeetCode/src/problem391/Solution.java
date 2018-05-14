package problem391;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    
    Map<Side, Rect> map;
    
    class Side {
        int x1;
        int y1;
        int x2; 
        int y2;
        public Side(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
        
        @Override
        public int hashCode() {
            int b = 199;
            
            int ans = x1;
            ans *= b;
            ans += x2;
            ans *= b;
            ans += y1;
            ans *= b;
            ans += y2;
            return ans;
        }
        
        @Override
        public boolean equals(Object o) {
            Side s = (Side) o;
            
            if (x1 == s.x1 && x2 == s.x2 && y1 == s.y1 && y2 == s.y2)
                return true;
            return false;
        }
    }
    
    class Rect {
        
        int x1;
        int y1;
        int x2; 
        int y2;
        
        Side[] sides;
        public Rect(Side[] sides, int x1, int x2, int y1, int y2) {
            this.sides = sides;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
        
         @Override
        public int hashCode() {
            int b = 199;
            
            int ans = x1;
            ans *= b;
            ans += x2;
            ans *= b;
            ans += y1;
            ans *= b;
            ans += y2;
            return ans;
        }
        
        @Override
        public boolean equals(Object o) {
            Rect s = (Rect) o;
            
            if (x1 == s.x1 && x2 == s.x2 && y1 == s.y1 && y2 == s.y2)
                return true;
            return false;
        }
        
    }
    
    public boolean isRectangleCover(int[][] rectangles) {
        
        map = new HashMap();
         
        for (int i = 0; i < rectangles.length; i++) { 
           int x1 = rectangles[i][0];
           int x2 = rectangles[i][2];
            
           int y1 = rectangles[i][1];
           int y2 = rectangles[i][3];
           
           Side sides[] = new Side[4];
            sides[0] = new Side(x1,x1, y1, y2);
            sides[1] = new Side(x2,x2, y1, y2);
            sides[2] = new Side(x1,x2, y1, y1);
            sides[3] = new Side(x1,x2, y2, y2);
            Rect r = new Rect(sides, x1, x2, y1, y2);
            
            
            while(true){
            boolean found = false;
            for (int j = 0; j < 4; j++) {
                if (map.containsKey(r.sides[j])) {
                    Rect r1 = map.get(r.sides[j]);
                    
                    if (overlap(r, r1))
                        return false;
                    
                    for (int k = 0; k < 4; k++)
                        map.remove(r1.sides[k]);
                    
                    r = merge(r, r1);
                    found = true;
                    
                    //break;
                }
                
            }
                if (!found)
                    break;
            }
            
            //if (!found) {
                for (int j = 0; j < 4; j++)
                    map.put(r.sides[j], r);
            //}
           
        }
        
        Set<Rect> uniques = new HashSet();
         Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            uniques.add((Rect)pair.getValue());
            //System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
         }
        
        /*
        Iterator<Rect> it1 = uniques.iterator();
        while( it1.hasNext()) {
            Rect r = it1.next();
            
            System.out.println(r.x1+" "+r.y1 + " "+r.x2+ " "+r.y2);
        } */
        
        //System.out.println(uniques.size());
        return (uniques.size() == 1);
        
         
        
    }
    boolean overlap(Rect r1, Rect r2) {
        if (r1.x1 <= r2.x1 && r1.x2 >= r2.x2 && r1.y1 <= r2.y1 && r1.y2 >= r2.y2)
            return true;
        
        if (r2.x1 <= r1.x1 && r2.x2 >= r1.x2 && r2.y1 <= r1.y1 && r2.y2 >= r1.y2)
            return true;
        
        return false;
        
    }
    
    Rect merge(Rect r1, Rect r2) {
        int x1 = Math.min(r1.x1, r2.x1);
        int x2 = Math.max(r1.x2, r2.x2);
        int y1 = Math.min(r1.y1, r2.y1);
        int y2 = Math.max(r1.y2, r2.y2);
         
        Side sides[] = new Side[4];
            sides[0] = new Side(x1,x1, y1, y2);
            sides[1] = new Side(x2,x2, y1, y2);
            sides[2] = new Side(x1,x2, y1, y1);
            sides[3] = new Side(x1,x2, y2, y2);
        
        Rect r = new Rect(sides,x1,x2,y1,y2);
        return r;
        
    }
}