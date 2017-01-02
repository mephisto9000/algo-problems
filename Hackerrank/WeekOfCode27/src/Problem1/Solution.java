package Problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	
	public int calc() throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		
		int v1 = p / 2;
		int v2 = (t - p) / 2;
		
		if (v1 > v2)
			return v2;
		else
			return v1;
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
