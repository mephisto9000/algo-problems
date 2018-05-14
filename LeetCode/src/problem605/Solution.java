package problem605;

class Solution {
    int[] flowerbed;
    int size ;
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        this.flowerbed = flowerbed;
        size = flowerbed.length;
        return rec(0, n);
    }
    
    boolean rec(int idx, int n){
                    
        if (idx >= size)
            return (n <= 0);
            
        
        if (flowerbed[idx]==1) {            
            return rec(idx+2, n);
        }
        
        boolean a1 ;
        //if (idx > 0)
            a1 = canPlace(idx) ? rec(idx+2, n-1) : false;
        //else
        //    a1 = rec(idx+2, n-1);
        
        boolean a2 = rec(idx+1, n);
        return a1 || a2;
    }
    
    boolean canPlace(int idx) {
        
            if (idx < size-1) {
                if (flowerbed[idx+1] == 0)
                {
                	if (idx > 0 ) {
                		if (flowerbed[idx-1]==0)
                			return true;
                		else
                			return false; }
                	else
                		return true;
                }
                else
                    return false;
            }
            else
                {
            	if (idx > 0 ) {
            		if (flowerbed[idx-1]==0)
            			return true;
            		else
            			return false; }
            	else
            		return true;
                }
                
        
    }
}