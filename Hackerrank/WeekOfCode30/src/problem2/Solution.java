package problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public String calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		String s = rec(n, sb);
		
		 
		
		return s;
	}
	
	public String rec(int n, StringBuffer sb)
	{			
						
		if (n <= 1)
			sb.append("int");
		else
		{
			sb.insert(0, "min(int, ");
						
			n--;			
			String s = rec(n, sb);
			
			
			sb.append(')');
		}
					
		return sb.toString();
					
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
