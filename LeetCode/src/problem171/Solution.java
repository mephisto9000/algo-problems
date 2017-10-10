package problem171;

class Solution {
    
    
    
    public int titleToNumber(String s) {
        StringBuffer sb = new StringBuffer();
        
        int idx = 0;
        int iidx = s.length() - 1;
        
        int v = 0; //1;
        
        while(idx < s.length())
        {
            char c = s.charAt(idx);
            int z = (int) (c - 'A') + 1;            
            
          
            
            int base = (int) Math.pow(26, iidx);
            
            v += base * z;
            
            idx ++;
            iidx --;
        }
        
        return v;
        
    }
}