package Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	public String calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src==null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String s = br.readLine();
		String t = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		
		//if (s.equals(t))
		//	return "Yes";
		
		for (int i = 0; i <= k; i++)
		{
			int j = s.length() - i;
			
			//if (j <=0)
				//j = 1;
			
			
			String s1 = "";
			
			if (j >=0)
				s1 = s.substring(0, j);
			
			String t1 = "";
			
			if (j >= 0)
			{
			if (t.length() >= j) 
				t1 = t.substring(0, j);
			else
				t1 = t;
			}
			
			if (t1.equals(s1) && t.length() - t1.length() == k - i)
				return "Yes";
		}
		return "No";
		
		/*
		
		for (int i = 0; i < t.length(); i++)
		{
			if (s.length() > ans+1 && t.length() > ans+1)
			{
				if (s.charAt(i) != t.charAt(i))
					ans = t.length() - i; 
			}
			else
				ans = t.length() - i;
			
			i++;
		}
		
		System.out.println(ans);
		
		ans += s.length() - ans;
		
		
		
		System.out.println(ans);
		if (ans == k)
			return "Yes";
		else
			return "No";
		*/
		
	}

	public static void main(String[] args) throws Exception{
		
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
