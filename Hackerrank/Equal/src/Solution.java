import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	int n;
	int[] colleagues; 
	
	public int[] calc() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int t = Integer.parseInt(br.readLine());
		
		int ans[] = new int[t];
		
		Arrays.fill(ans, Integer.MAX_VALUE);	
		for (int i = 0; i < t; i++)
		{
			n = Integer.parseInt(br.readLine());
			
			colleagues = new int[n];
			
			 
			
			String[] vals = br.readLine().split(" ");
			
			int ops = 0;  
			
			int shift = 0;
			
			int max = 0 ; 
			int min = Integer.MAX_VALUE; 
			for (int j = 0; j < n; j++)
			{
				colleagues[j] = Integer.parseInt(vals[j]);
				 
				
				
				if (colleagues[j] > max)
					max = colleagues[j];
				
				if (colleagues[j] < min)
					min = colleagues[j];
				
			
			}
			
			for (int j = 0; j < n; j++)
			{
				colleagues[j] = max - colleagues[j] + min;
			}
			
			
			 
			
			int add = 0;
			for (int z = 0; z < 6; z++) //5; z++)
			{
				ops = 0;
				for (int j = 0; j < n; j++)
				{
					
					ops += rec(j, z, max);
				}
				 
			 
			
			if (ops < ans[i])
				ans[i] = ops;
			
			
			}
			
			
		}   // i over t
		
		return ans;
	}
	
	int rec(int idx, int hand, int max) 
	{
		if (idx >= n)
			return -1;
		
		int shift = colleagues[idx];
		int val = max + hand;  
		int ans = 0;
		
		while(shift < val)
		{
			 
			int dif = val - shift;
			
			if (dif >= 5)
			{
				shift += 5;  
				ans ++;  
				 
			}
			else
			if (dif >= 2)
			{
				shift += 2;  
				ans ++;  
				 
			}
			else			
			if (dif >= 1)
			{
				shift += 1;  
				ans ++;  
			}
			
			
		}
			
		
		return ans;
		
		
	}
	

	public static void main(String[] args) throws Exception  {
		

		Solution sol = new Solution();
				
		int []ans = sol.calc();
		for (int i = 0; i < ans.length; i++)
		{
			System.out.println(ans[i]);
		}
			

	}

}
