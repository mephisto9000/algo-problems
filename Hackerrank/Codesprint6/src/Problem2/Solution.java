package Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	int [] init;
	int [] desire;
	int n = 5;
	
	public int calc() throws Exception
	{
		BufferedReader br;
		
		if (src == null)
			br= new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		init = new int[n];
		desire = new int[n];
		
		String [] vals = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++)
			init[i] = Integer.parseInt(vals[i]);
		
		vals = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++)
			desire[i] = Integer.parseInt(vals[i]);
		
		
		int ans = 0;
		for (int i = 0; i < n; i++)
		{
			if (Math.abs(init[i] - desire[i] ) < 5)
				ans += Math.abs(init[i] - desire[i] );
			else
				ans += 10 - Math.abs(init[i] - desire[i] ); 
		}
		
		return ans;
		
	}

	public static void main(String[] args) throws Exception{
		

		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
