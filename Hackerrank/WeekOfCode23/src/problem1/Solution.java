package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	public String calc() throws Exception
	{
		BufferedReader br = null;
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer ans = new StringBuffer();
		
		for (int i = 0; i < n; i++)
		{
			
			if (ans.length() > 0)
				ans.append('\n');
			
			if (Integer.parseInt(br.readLine()) % 2 == 0)
				ans.append("Yes");
			else
				ans.append("No");
			
		}
		
		return ans.toString();
	}
	

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
