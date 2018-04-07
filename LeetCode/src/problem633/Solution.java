package problem633;

class Solution {
    
    Set<Integer> squares;
    
    public boolean judgeSquareSum(int c) {
                
        int z = 0;
        squares = new HashSet();
                         
        for (int i = 0; i <= Math.sqrt(c)  ; i++)
        {
            
            int ii = i*i;
            
            squares.add(ii);
            
            int v = c - ii;
            
            if (squares.contains(v))
                return true;
        }
        return false;
        
    }
    
    
}