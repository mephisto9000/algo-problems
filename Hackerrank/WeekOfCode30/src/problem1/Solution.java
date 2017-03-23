package problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String vals[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int t = Integer.parseInt(vals[1]);
		
		vals = br.readLine().split(" ");
		
		int k = 0;
		int bowl = n;
		for (int i = 0; i < t-1; i ++)
		{
			int v = Integer.parseInt(vals[i]);
			
			bowl -= v;
			
			if (bowl    < 5 )
			{
				k += n - bowl; 
				bowl = n;
			}
			
				
		}
										
		return k;
	}

	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
