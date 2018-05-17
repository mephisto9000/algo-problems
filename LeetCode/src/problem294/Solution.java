package problem294;

class Solution {
    
    char[] mtx;
    long key;
    Map<Long, Boolean> memo;
    public boolean canWin(String s) {
        mtx = s.toCharArray();
        key = 0;
        memo = new HashMap();
        
        
        return rec();
        
    }
    
    
    boolean rec() {
        
        if (memo.containsKey(key))
            return memo.get(key);
        
    	boolean move = false;
        
        for (int i =   1; i < mtx.length; i++) {
        	
            if (mtx[i-1] == '+' && mtx[i] == '+') {
            	move = true;
                mtx[i-1] = '-';
                mtx[i] = '-';
                key ^= (1 << i);
                key ^= (1 << (i-1));
                
                boolean canWin= (!rec());
                    
                mtx[i] = '+';
                mtx[i-1] = '+';
                
                key ^= (1 << i);
                key ^= (1 << (i-1));
                
                if (canWin) {
                    memo.put(key, true);
                	return true;
                }
            }
                
        }
        
        memo.put(key, false);
        return false;
    }
}