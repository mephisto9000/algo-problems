package Problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String[] vals = br.readLine().split(" ");
		
		int m = Integer.parseInt(vals[0]);
		int n = Integer.parseInt(vals[1]);
		
		if (m % 2 != 0)
			m++;
		if (n %2 != 0)
			n++;
		
		return ((m/2) * (n/2));
		
		
		
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());
		


	}

}
