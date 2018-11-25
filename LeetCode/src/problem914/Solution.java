package problem914;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {        
        Map<Integer, Integer> m = new HashMap();        
        for (Integer x: deck) {
            int v = m.getOrDefault(x, 0);
            m.put(x, v+1);
        }        
        return process(m);                
    }
    
    boolean process(Map<Integer, Integer> m) {
        
        for (int i = 2; i<=10000; i++) {
        boolean ok = true;
        for (Map.Entry<Integer, Integer> me: m.entrySet()) {            
            if (me.getValue()==1 || me.getValue()%i!=0) {
                ok = false;
                break;
            }
        }
        if (ok)
            return true;
        }
        return false;
    }
    
}