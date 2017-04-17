package p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public String[] calc() throws Exception
	{
		String []ans = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t =Integer.parseInt(br.readLine());
		
		ans = new String[t];
		
		for (int i = 0; i < t; i++)
		{
			String s = br.readLine();
			
			int k = Character.getNumericValue(s.charAt(s.length()-1));
			
			char[] c = s.substring(0, s.length()-1).toCharArray();
			
			int a = 0;
			for (int j = 0; j < c.length - k; j++)
				if (c[j] == '-')
				{					
					flip(c, j, k);
					a++;
				}
			
			StringBuffer atmp = new StringBuffer();
			
			if (isPossible(c))
			{
				atmp.append("Case #");
				atmp.append(i+1);
				atmp.append(": ");
				atmp.append(a);								
			}
			else
			{
				atmp.append("Case #");
				atmp.append(i+1);
				atmp.append(": IMPOSSIBLE");				
			}
			
				
				
			ans[i] = atmp.toString();
			
							
				
		}
		
		
		return ans;
	}
	
	boolean isPossible(char[] c)
	{
		
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == '-')
				return false;
		}
		return true;
		
	}
	
	void flip(char[] c, int idx, int k)
	{
		for (int i = 0; i < k; i++)
		{
			c[idx + i] = c[idx + i] == '+' ? '-' : '+'; 
		}
	}

	public static void main(String[] args) throws Exception{
		
		Main m = new Main();
		
		String[] vals = m.calc();
		
		for (int i = 0; i < vals.length; i++)
			System.out.println(vals[i]);
		

	}

}
