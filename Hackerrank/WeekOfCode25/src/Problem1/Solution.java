package Problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	String src = null;

	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src==null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String vals[] = br.readLine().split(" ");
		
		int m = Integer.parseInt(vals[0]);
		int n = Integer.parseInt(vals[1]);
		
		int a[] = new int[m];
		int b[] = new int[n];
		
		vals = br.readLine().split(" ");
		
		for (int i = 0; i < m; i++)
			a[i] = Integer.parseInt(vals[i]);
		
		vals = br.readLine().split( " ");
		
		int bmin = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++)
		{
			b[j] = Integer.parseInt(vals[j]);
			if (b[j] < bmin)
				bmin = b[j];
		}
		
		
		Arrays.sort(a);
		
		int ans = 1;
		for (int i = 0; i < m; i++)
		{
			if (ans % a[i] != 0)
			{
				if (a[i] % ans == 0)
					ans = a[i];
				else
					ans *= a[i];
			}
		}
		
		//System.out.println("here !" + ans);
		/*
		for (int j = 0; j< n; j++)
		{
			if (b[j] % ans != 0 )
				return 0;
		}*/
		
		//System.out.println("here ?");
		
		int ans1 = 0;
		ans = 1;
		int ansbase = ans;
		
		while (ans <= bmin)
		{
			
			//ans *=ansbase;
			boolean flag = true;
			
			for (int i = 0; i < n; i++)
			{
				if (b[i] % ans !=0)
				{
					flag = false;
					break;
				}
				
			
				
			}
			
			
			
			for (int j = 0; j < m; j++)
			{
				if (ans % a[j] !=0)
				{
					flag = false;
					break;
				}
			
			} 
			
			if (flag)//ans % ansbase == 0)
			{
				//System.out.println(ans);
			ans1++;
			}
			
			
			ans++;
				
		}
		
		return ans1;
		
		
	
	}
	
	public static void main(String[] args) throws Exception{
	
		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
