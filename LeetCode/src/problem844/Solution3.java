package problem844;

class Solution {
    
    String strs[];
    int idxs[];
    
    public char getNext(int idx) {
        char c = ' ';
        
        int sharps = 0;
        while(idxs[idx] >= 0) {
            c = strs[idx].charAt(idxs[idx]--);
            if (c == '#') {
                c = ' ';
                sharps ++;
            } else 
            if (sharps > 0) {
                c = ' ';
                sharps --;
            } else {                    
                break;
            }                
        }
        return c;
        
    }
    public boolean backspaceCompare(String S, String T) {
        
        strs = new String[2];
        idxs = new int[2];
        
        idxs[0] = S.length()-1;
        idxs[1] = T.length()-1;
        strs[0] = S;
        strs[1] = T;
        
        while(idxs[0] >= 0 || idxs[1] >= 0) {
            //get terminal si
            char sc = getNext(0);
            char tc = getNext(1);
            if (sc != tc)
                return false;            
        }
        return true;
        
    }
}