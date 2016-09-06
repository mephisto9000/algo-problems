package ProblemA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String str = null;
	
	int mtx[][];
	
public String calc() throws Exception
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
	
	boolean res = true;
	for (int i = 0; i < n; i++)	
	{
		if (mtx[i][i]!=0)
			return "NO";
		
		for (int j = 0; j < n; j++)		
			if (mtx[i][j]!=mtx[j][i])
			{
				return "NO";
				
			}
	}
		
	
		
	return "YES";
	
	
}

public static void main(String args[]) throws Exception
{
	Solution sol = new Solution();
	System.out.println(sol.calc());
}


	

}
