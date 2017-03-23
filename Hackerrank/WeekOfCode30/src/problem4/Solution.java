package problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	
	public static String src = null;
	
	int x[]; //altitude
	int w[]; //weight
	int logs[];
	
	int n;
	int k;
	
	int memo[][][];
	
	
	
	
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src != null)
			br = new BufferedReader(new FileReader(src));
		else
			br = new BufferedReader(new InputStreamReader(System.in));
		
		String vals[] = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		k = Integer.parseInt(vals[1]);
		
		x = new int[n];
		w = new int[n];
		logs = new int[n];
		
		Arrays.fill(logs, 1);
		
		 
		
		for (int i = 0; i < n; i++)
		{
			vals = br.readLine().split(" ");
			
			x[n-i-1] = Integer.parseInt(vals[0]);
			w[n-i-1] = Integer.parseInt(vals[1]);
						 
		}
		
		memo = new int[n+1][n+1][1000000];
		
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
					Arrays.fill(memo[i][j], -1);
				 
		
		 
 		  
		
		return rec(0, n);
				 
		
		//return cost;
		
		
	}
	
	
	public int rec(int i, int tmpk)
	{		 		
		
		
		
		if (tmpk == k)
		{						 
			return 0;
		}
		
		
		
		if (i >=n)  
			return 10000000;
		
		
		
		if (memo[i][tmpk][logs[i]]  != -1)
		{
			//System.out.println(memo[i][tmpk][logs[i]]) ;
			return memo[i][tmpk][logs[i]] ;
		}
		
		
		if (i < (n-1) )
		{
			int v1 = rec(i+1, tmpk);
			
			w[i+1]+=w[i] ; 
			
			 
			int tmp_logs = logs[i];
			
			logs[i+1] += tmp_logs;
			
			int v2 = w[i] * (- x[i + 1] + x[i] )+rec(i+1, tmpk-1);
			w[i+1] -=w[i];
			
			logs[i+1] -= tmp_logs;
			
			memo[i][tmpk][logs[i]] = min(v1, v2);
			
			return memo[i][tmpk][logs[i]];
		}
		
		return 10000000;
	}
	
	public int min( int a , int b)
	{
		if (a < b)
			return a;
		else
			return b;
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
