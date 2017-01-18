package Chapter5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem5_2 {
	
	
	/**
	 * reads num, a and b; then swapps a't and b'th bits in num
	 * @return nimber with ath and bth bits swaped
	 * @throws Exception
	 */
	public int calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] vals = br.readLine().split(" ");
		
		int num = Integer.parseInt(vals[0]);
		
		int a = Integer.parseInt(vals[1]) - 1;
		int b = Integer.parseInt(vals[2]) - 1;
		
		/*
		int[] bits = new int[32];
		
		for (int i = 0; i < 32; i++)
		{
			bits[i] = num & 1; 
			num >>=1;
		}
		
		int tmp = bits[a];
		bits[a] = bits[b];
		bits[b] = tmp;
		
		num = 0;
		for (int i = 0; i < 32; i++)
		{
			num <<= 1;
			num |= bits[31 - i];
			
		}
		*/
		
		num ^= (1 << a) | (1 << b); 
		
		
		
		return num;
						
	}

	public static void main(String[] args) throws Exception{
		
		Problem5_2 p = new Problem5_2();
		
		System.out.println(p.calc());

	}

}
