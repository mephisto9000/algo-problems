package problem593;

import java.util.HashSet;
import java.util.Set;

class Solution {
    
    
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
                        
        
    double d1 =   Math.sqrt(Math.pow(p1[0] - p2[0], 2)  +  Math.pow(p1[1] - p2[1], 2)); 
    
    double d2 =  Math.sqrt(Math.pow(p1[0] - p3[0], 2)  +  Math.pow(p1[1] - p3[1], 2));
        
    double d3 =  Math.sqrt(Math.pow(p1[0] - p4[0], 2)  +  Math.pow(p1[1] - p4[1], 2));
    
    double d4 =  Math.sqrt(Math.pow(p2[0] - p3[0], 2)  +  Math.pow(p2[1] - p3[1], 2) );   
    
    double d5 = Math.sqrt(Math.pow(p2[0] - p4[0], 2)  +  Math.pow(p2[1] - p4[1], 2) );   
        
    double d6 =  Math.sqrt(Math.pow(p3[0] - p4[0], 2)  +  Math.pow(p3[1] - p4[1], 2) ); 
    
    
        
    Set<Double> s = new HashSet();
    
    if (d1 == 0 || d2 == 0 || d3 == 0 || d4 == 0 || d5 == 0 || d6 == 0 )
    	return false;
    
    s.add(d1);    
    s.add(d2);        
    s.add(d3);
    s.add(d4);
    s.add(d5);
    s.add(d6);
        
    if (s.size() == 2)
        return true;
    else
        return false;
       
    }
    
}