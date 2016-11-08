package Problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;

public class Solution {
	
	String src = null;
	
	BigInteger[] dividers;
	
	BigInteger n;
	int m;
	
	public int calc() throws Exception
	{
		int ans = 0;
		
		
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		
		String[] vals = br.readLine().split(" ");
		
		n = new BigInteger(vals[0]);		
		m = Integer.parseInt(vals[1]);
		
		
		vals = br.readLine().split(" ");
		
		dividers = new BigInteger[m];
		
		for (int i = 0 ; i < m; i++)
		{
			dividers[i] = new BigInteger(vals[i]);
		}
		
		
		
		if (rec(n))
			return 0;
		else
			return 1;

	}
	
	
	/*
	 * 
	 boolean isWinning(position pos) {
    	moves[] = possible positions to which I can move from the
		position pos;
    	for (all x in moves) 
        	if (!isWinning(x)) return true;
    
    	return false; 
	}
	 */
	
	public boolean rec(BigInteger divisor)
	{
		for (int i = 0; i < m; i++ )
		{
			if (divisor.mod(dividers[i]).intValue() == 0)
			{
				//ret
				BigInteger tmp = divisor.divide(dividers[i]);
				
				if (!rec(tmp))
					return true;
			}
		}
		return false;
		
		
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		int r = sol.calc();
		
		if (r == 0)
			System.out.println("First");
		else
			System.out.println("Second");
		

	}

}
