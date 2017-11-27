package problem84;

import java.util.Stack;

public class Solution {
	
	public int largestRectangleArea(int[] heights) {
		
		if (heights == null || heights.length==0)
            return 0;
		
		int n = heights.length;
		
		Stack<Integer> s = new Stack();
		
		int max = 0;
		for (int i = 0; i <= n; i++)
		{
			
			int h = 0;
			if (i < n)
				h =  heights[i];
			 
			if (s.isEmpty() || (i < n &&  heights[i] >= heights[s.peek()]))		
			{
				s.push(i);
 
			}
			else
			{
 				int top = s.pop();
				 				
				max = Integer.max(max,  heights[top]  * (!s.isEmpty()?  i - s.peek() - 1 : i));   
				i--;
			}
			
		}
		
		return max;
	    
	}

}
