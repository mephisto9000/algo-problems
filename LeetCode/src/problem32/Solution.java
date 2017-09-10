package problem32;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
	
	 
	public int collect(Stack st)
	{
		int v = 0;
		while(!st.isEmpty() && (Integer)st.peek() >=0 )
		{
			v += (Integer)st.pop();
		}
		
		return v;
		
	}
    public int longestValidParentheses(String s) {
        
        int max = 0;
        
        int localMax = 0;
        int count = 0;
        
        int left = -1;
        int right = -2;
        
        Stack st = new Stack();
        
        for (int i = 0; i < s.length(); i++)
        {
                     
        	
            char c = s.charAt(i);
            if (c == '(')
            {            	            	
            	st.push(left);
            	
            }
            
            if (c == ')') 
            {
                if (!st.isEmpty() && (Integer)st.peek() >=-1 ) 
                {
                	int v = collect(st); 
                	
                	if (v >0)
                	{                		
                		if (!st.isEmpty() && (Integer)st.peek() ==left )
                		{
                			st.pop();
                			v+=2;
                			st.push(v);
                		}
                		else
                		{
                			st.push(v);
                			st.push(right);
                		}
                	}
                	else
                	{
                		st.pop();
                		st.push(2);
                	}
                	                	 
                }
                else
                {                	
                	st.push(right);
                }
                
            }                                                         
             
        }
                        
        max = 0;
        localMax = 0;
        while(!st.isEmpty())
        {        	
        	
        	int v = (Integer) st.pop();        	
        	if (v > 0)
        		localMax += v;
        	else
        		localMax = 0;
        	
        	if (localMax > max)
        		max = localMax;
        	
        }
        
        
        return max;
    }
}