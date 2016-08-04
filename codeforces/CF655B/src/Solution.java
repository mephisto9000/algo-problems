import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int k = Integer.parseInt(vals[1]);
		
		
		

		//if (k > Math.floorDiv(n, 2))
		//	k = Math.floorDiv(n, 2);
		
		//if ()
		int[] mtx = new int[n];
		for (int i = 0; i < n; i++)
			mtx[i] = i+1;
		
		
		int last = n-1;
		int start = 0;
		
		int z = 0;
		while(last > start)
		{
			int t = mtx[last];
			mtx[last] = mtx[start];
			mtx[start] = t;
			
			last--;
			start++;
			
			z++;
			if (z == k)
				break;
		}
		
		//for (int i = 0; i < n; i++)
			//System.out.println(mtx[i]+ " ");
		
		int ans = 0 ;
		for (int i = 0; i < n; i++)
		{
			for (int j = i; j < n; j++ )
			{
				if (mtx[i] > mtx[j])
				{
					//if (ans == 0)
					ans ++;
				}
			}
		}
		
		
		
		System.out.println(ans);
		/*
		if (k*2 < n)
			k = k*2 +1;
		else
			if (k*2 == n)
			{
				
			}
			else
				k = Math.floorDiv(n, 2);
		
		
		System.out.println(k);
		
		
		BigInteger fact = BigInteger.ONE; //new BigInteger(1);
		
		BigInteger smallFact = BigInteger.ONE;
		//int n_2 = n-
		
		if (k <= 1)
		{
			fact = BigInteger.ZERO;
		}
		else
		for (int i = 1; i <= k; i++)
		{
			fact = fact.multiply(BigInteger.valueOf(i));
			
			if (i == (k-2))
				smallFact = fact.multiply(BigInteger.valueOf(2));
				
			
		}
		
		
		
		System.out.println(fact.divide(smallFact)); */
		
	}

	public static void main(String[] args) throws Exception{
		
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
