package problem20;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		

	}
	
	public boolean isValid(String s) {
		
		Stack<Character> st = new Stack<Character>();
		
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			if (isStart(c))
				st.push(c);
			else
			{
				char c1;
				if (!st.isEmpty())
				{
					 c1 = st.peek();
				}
				else
					return false;
				
				if (check(c1, c))
					st.pop();
				else
					return false;
				
			}
		}
		
		if (!st.isEmpty())
			return false;
		
		return true;
	        
	}
	
	public boolean check(char c1, char c2)
	{
		if (c1 == '{' && c2 == '}')
			return true;
		
		if (c1 == '(' && c2 == ')')
			return true;
		
		if (c1 == '[' && c2 == ']')
			return true;
		
		return false;
	}
	
	public boolean isStart(char c)
	{
		if (c == '{' || c == '(' || c == '[')
			return true;
		return false;
	}

}
