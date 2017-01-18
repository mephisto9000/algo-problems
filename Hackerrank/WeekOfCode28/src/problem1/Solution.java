package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	
	int n; //trips
	int c; //capacity
	int m; //boats
		
	
	public boolean calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String[] vals = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		c = Integer.parseInt(vals[1]);
		m = Integer.parseInt(vals[2]);
				
		
		
		vals = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
		{
			int pi = Integer.parseInt(vals[i]);
			
			if ((float)pi / (float)m > c )
				return false;
		}
		
		return true;
		
		
	}
	

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		boolean ans = sol.calc();
		
		if (ans)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
