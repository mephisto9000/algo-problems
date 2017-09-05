package problem32;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        
        int max = 0;
        
        int localMax = 0;
        int count = 0;
        
        Stack st = new Stack();
        
        for (int i = 0; i < s.length(); i++)
        {
                     
        	
            char c = s.charAt(i);
            if (c == '(')
            {
            	//if (st.isEmpty() && (Character)st.peek() == '(')
            	{
            		st.push('(');
            		
            	}
            	
            	
            	count ++;
            	
            }
            
            if (c == ')' && count > 0)
            {
                            	            	
                count--;
                
                if (!st.isEmpty() && (Character)st.peek() == '(')
                {
                	st.pop();
                	localMax++;
                }
                
                //if (max < localMax)
            	//	max = localMax;
            }
                        
            //if (localMax > max)
            //    max = localMax;            
            
            if (count < 0)
            {
                count = 0;
                
                if (localMax > max)
                	max  = localMax;
                localMax = 0;
                st.clear();
                                
            }
        }
        
        if (localMax > max)
        	max = localMax;
        
        return max * 2;
    }
}