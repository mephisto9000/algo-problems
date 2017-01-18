package problem2;

import java.util.Scanner;

public class Solution {
	
	
	public String calc() throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		
		int q = s.nextInt();
		
		for (int i = 0; i < q; i++)
		{
			long x = s.nextLong();
			
			long v = 0;
			long xx = 1;
			
			
			while(xx <=  x)
			{
				if ((x & xx) == 0)
					v = v ^ xx; 

				xx = xx << 1; 
							 
			}
			
			
			if (i > 0)
				sb.append("\n");			
			sb.append(v);
			
		}
		
		return sb.toString();
				
	}

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		
		System.out.println(sol.calc());
		

	}
	
	
	
	
	 
	
	
}





