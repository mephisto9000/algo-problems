package problem202;

class Solution {
    public boolean isHappy(int n) {
	        
	        if (n == 1)
	            return true;
	        
	        Set s = new HashSet();
	        
	        
	        return happyNum(n, s);
	        
	    }
	    
	    boolean happyNum(int val, Set s)
	    {
	         
	        
	        if (s.contains(val))
	            return false;
	        s.add(val);
	        
	        String sstr = Integer.toString(val);
	        
	        int tot = 0;
	        
	        for (int i = 0; i < sstr.length(); i++)
	        {            
	            int x =  Character.getNumericValue(sstr.charAt(i));
	            
	            val = val / 10;
	            
	            tot += x*x;
	        }
	        
	        if (tot == 1)
	            return true;
	        else
	        {
	           
	            return happyNum(tot ,s);
	        }
	    }
}