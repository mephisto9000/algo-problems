package problem846;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> m = new TreeMap<>();

        for (int i = 0; i < hand.length; i++) {
            int v = m.getOrDefault(hand[i], 0);
            m.put(hand[i], v+1);    
        }
                
        while(!m.isEmpty()) {
            int x = m.firstKey(); 
            for (int j = 0; j < W; j++) {
                int v = m.getOrDefault(x+j,0);
                if (v == 0)
                    return false;
                if (v == 1)
                    m.remove(x+j);
                else
                    m.put(x+j, v-1);
            }
        }
        return true;                    
    }     
}