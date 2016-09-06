package ProblemC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String str = null;
	
	int mtx[][];
	
public int calc() throws Exception
{
	BufferedReader br;
	
	if (str == null)
		br = new BufferedReader(new InputStreamReader(System.in));
	else
		br = new BufferedReader(new FileReader(str));
	
	int n = Integer.parseInt(br.readLine());
	
	mtx = new int[n][n];
	
	for (int i = 0; i < n; i++)
	{
		String[] vals = br.readLine().split(" ");
		
		for (int j = 0; j < n; j++)
		{
			mtx[i][j] = Integer.parseInt(vals[j]);
		}
	}
	
	int ans = 0;
	for (int i = 1; i < n; i++)	
	{
		for (int j = 0; j < i; j++)		
			if (mtx[i][j]==1)			
				ans ++;

	}
		
		
	return ans;
	
	
}

public static void main(String args[]) throws Exception
{
	Solution sol = new Solution();
	System.out.println(sol.calc());
}


	

}
