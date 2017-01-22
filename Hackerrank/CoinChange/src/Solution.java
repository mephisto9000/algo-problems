import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	int n;	//cents
	
	int m; 	//coins
	int[] c; //coins
	long[][]memo;
	
	public long calc() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String[] vals = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);  
		m = Integer.parseInt(vals[1]);  
		
		
		vals = br.readLine().split(" ");
		c = new int[m];
		
		
		memo = new long[m][n+1];
		
		for (int i = 0; i < m; i++)
			Arrays.fill(memo[i], -1L);
		
		for (int i = 0; i < m; i++)
			c[i] = Integer.parseInt(vals[i]);
		
		
		long ans = rec(0, n);
		 
		return ans;
	}
	
	
	long rec(int idx, int rem)
	{
		if (idx >= m)
			return -1;

		//System.out.println("idx == "+idx + " rem == "+rem);

		if (memo[idx][rem] != -1)
			return memo[idx][rem];
		
		long ans = 0;
		int base = 0;
		
		if (idx == m-1) 
		{
			 if (rem % c[idx] == 0)
				 return 1;
			 else
				 return -1;
		}
		//1059512291
		//64027917156
		
		while (base <= rem)
		{
			
			long next = rec(idx+1, rem - base);
			if (next >=0)
				ans += next;
			
			base += c[idx];

		}
		
		memo[idx][rem] = ans;
		
		
		return ans;
	}

	public static void main(String[] args) throws Exception  {
		

		Solution sol = new Solution();
				
		long  ans = sol.calc();
		 
		System.out.println(ans);
		
			

	}

}
