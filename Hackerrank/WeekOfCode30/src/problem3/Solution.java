package problem3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	char vows[] = {'a', 'e', 'i', 'o', 'u'};
	char cons[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z', 'w'};
	
	Set vset;
	Set cset;
	
	StringBuffer sb  = null;
	
	public void calc() throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		sb = new StringBuffer();
		
		vset = new HashSet();
		
		for (int i = 0; i < vows.length; i++)
		{
			vset.add(vows[i]);
		}
		
		cset = new HashSet();
		
		for (int i = 0; i < cons.length; i++)
		{
			cset.add(cons[i]);
		}
		
		//for (int i = 0; i < n; i++)
		
		for (int i = 0; i < vows.length; i++)
		{
			sb.append(vows[i]);
			rec(n);
			sb.deleteCharAt(0);
		}
		
		for (int i = 0; i < cons.length; i++)
		{
			sb.append(cons[i]);
			rec(n);
			sb.deleteCharAt(0);
		}
		
		
			
		
	}
	
	
	public void rec(int n )
	{
		
		char ex = sb.charAt(sb.length() - 1);
		
		if (sb.length() < n)
		{
			if (vset.contains(ex))
			{
				for (int i = 0; i < cons.length; i++)
				{
					sb.append(cons[i]);
					rec(n);
					sb.deleteCharAt(sb.length()-1);					
				}
				
			}
			else			
			{
				for (int i = 0; i < vows.length; i++)
				{
					sb.append(vows[i]);
					rec(n);
					sb.deleteCharAt(sb.length()-1);					
				}
			
			}
			
		}
		else
		{
			System.out.println(sb.toString());
			return;
		}
	}

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		sol.calc();

	}

}
