package problem844;

class Solution {
    public boolean backspaceCompare(String S, String T) {
    
        
        int sIdx = S.length()-1;
        int tIdx = T.length()-1;
        
        int sOff = 0;
        int tOff = 0;
         
        while(sIdx >= 0 || tIdx >= 0) {
            sIdx -= sOff;
            tIdx -= tOff;
            sOff = 0;
            tOff = 0;
            
            while(sIdx >= 0) {
                if (S.charAt(sIdx) == '#') {
                    sOff ++;
                    sIdx --;
                }
                else {
                    if (sOff == 0)
                        break;
                    sIdx --;
                    sOff -- ;
                }
            }
            
            while(tIdx >= 0) {
                if (T.charAt(tIdx)=='#') {
                    tOff ++;
                    tIdx --;
                }
                else {
                    if (tOff == 0)
                        break;
                    tIdx --; 
                    tOff --;
                }
            }
            
            if (sIdx < 0 && tIdx < 0)
                return true;
            if ((sIdx >= 0 && tIdx < 0) || (tIdx >= 0 && sIdx < 0) || (S.charAt(sIdx)!=T.charAt(tIdx)))
                return false;
            sIdx --;
            tIdx --;
                
        }
        
        return true;
        
    }        
}