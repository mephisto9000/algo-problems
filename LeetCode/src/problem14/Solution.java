package problem14;

public class Solution {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		String[] arr = {"c", "c"};
		String ans = sol.longestCommonPrefix(arr);
		
		System.out.println("ans == "+ans+".");

	}
	
	
	public String longestCommonPrefix(String[] strs) {
	    int n = strs.length;
	    StringBuffer prefix = new StringBuffer();
	    
	    if (strs.length == 0)
	    	return "";
	    
	    int maxLen = 0;
	    for (int i = 0; i < strs.length; i++)
	    {
	    	if (strs[i].length() > maxLen)
	    		maxLen = strs[i].length();
	    }
	    
	    int cid = 0;
	    char c = 0;
	    while(true)
	    {
	    for (int i = 0; i < n; i++)
	    {
	    	if (c == 0 )
	    	{
	    		//newP.append(strs[i].charAt(cid));
	    		
	    		if (strs[i].length() <= cid)
	    			return prefix.toString();
	    		else
	    		{
	    			c = strs[i].charAt(cid);
	    			continue;
	    		}
	    	}
	    	else
	    	{	    		
	    		if (strs[i].length() <= cid)
	    			return prefix.toString();
	    		else
	    		{
	    			if (strs[i].charAt(cid) != c)
	    				return prefix.toString();
	    		}
	    	}
	    }
	    prefix.append(c);
	    c = 0;
	    cid ++;
	    
	    if (cid > maxLen)
	    	break;
	    }
	    
	    if (prefix.length() == 0)
	    	prefix.append("");
	    
	    return prefix.toString();
	    
	}

}
