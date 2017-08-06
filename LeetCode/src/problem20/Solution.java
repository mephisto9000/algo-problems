package problem20;

public class Solution {

	public static void main(String[] args) {
		

	}
	
	public boolean isValid(String s) {
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (int i = 0; i < s.length(); i++)
		{
			char x = s.charAt(i);
			switch (x)
			{
			case '{':
				a++;
				break;
			case '}':
				a--;
				break;
			case '[':
				b++;
				break;
			case ']':
				b--;
				break;
			case '(':
				c++;
				break;
			case ')':
				c--;
				break;
			}
									
		}
		
		if (a != 0 || b != 0 || c != 0)
			return false;
		
		return true;
	        
	}

}
