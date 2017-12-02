package problem299;

class Solution {
    public String getHint(String secret, String guess) {
    	
    	int sl = secret.length();
    	int gl = guess.length();
    	
    	int b = 0;
    	int c = 0;
 
    	Map<Character, Integer> smap = new HashMap();
    	
    	
    	
    	for (int i = 0; i < sl; i++)
    	{
    		if (guess.length() <= i)
    		   break;
    		
    		if (secret.charAt(i) == guess.charAt(i))
    				b ++;
    	}
    	
    	for (int i = 0 ; i < sl; i++)
    	{
    		char ctmp = secret.charAt(i);
    		if (smap.containsKey(ctmp))
    		{
    			int v = smap.get(ctmp);
    			v++;
    			smap.put(ctmp,  v);
    		}
    		else
    		{
    			smap.put(ctmp,  1);
    		}
    	}
     	int min = sl < gl ? sl : gl;
     	
     	
    	for (int i = 0; i < gl; i++)
    	{
    		char ctmp = guess.charAt(i);
    		if (smap.containsKey(ctmp))
    		{
    			int v = smap.get(ctmp);
    			v--;
    			c++;
    			if (v > 0)
    				smap.put(ctmp,  v);
    			else
    				smap.remove(ctmp);
    		}
    	}
    	
    	c -= b;
    	
    	
    	return b+"A"+c+"B";
    	
    	
    	 
    }
}