package problem168;

class Solution {
    
    StringBuffer res = new StringBuffer();
    Map<Integer, Character> mtx;
    public String convertToTitle(int n) {        
        
        mtx = new HashMap<Integer, Character>();
        
        
        
        mtx.put(1, 'A');
        mtx.put(2, 'B');
        mtx.put(3, 'C');
        mtx.put(4, 'D');
        mtx.put(5, 'E');
        mtx.put(6, 'F');
        mtx.put(7, 'G');
        mtx.put(8, 'H');
        mtx.put(9, 'I');
        mtx.put(10, 'J');
        mtx.put(11, 'K');
        mtx.put(12, 'L');
        mtx.put(13, 'M');
        mtx.put(14, 'N');
        mtx.put(15, 'O');
        mtx.put(16, 'P');
        mtx.put(17, 'Q');
        mtx.put(18, 'R');
        mtx.put(19, 'S');
        mtx.put(20, 'T');
        mtx.put(21, 'U');
        mtx.put(22, 'V');
        mtx.put(23, 'W');
        mtx.put(24, 'X');
        mtx.put(25, 'Y');
        mtx.put(26, 'Z');
        
        
        return rec(n);
    }
    
    String rec(int n)
    {
        if (n == 0)
            return "";
        
        int rem = n % 26 ;
        int base = n / 26 ;
        
        String ans;  
        if (rem > 0)
        	ans = rec(base) + mtx.get(rem); //-1
        else
        {
        	if (base > 0)
        			ans = rec (base - 1) + "Z"; 
        		else
        			ans = "" + mtx.get(base);
        }
        
        return ans;
       
    }
    
    
}