package Problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	public void calc() throws Exception
	{
		int ans = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++)
		{
			
			ans = 0;
			String[] vals = br.readLine().split(" ");
			
			int a = Integer.parseInt(vals[0]);
			int b = Integer.parseInt(vals[1]);
			
			
			
			int d = Integer.parseInt(vals[2]);
			
			int max = a > b ? a : b;
			
			int min = (a + b) - max;
			
			int dif = max - min;
			
			int remind ;
			
			int base = d / max;
			 remind = d - base*max;
			 
			 /*
			if (d / min < base)
			{
				base = d / min;
				remind = d - base*min;
			} */
			 
			
			ans = base;
			
			//System.out.println(1104 % 102);
			
			
			//if (remind % dif == 0 && base > 0)
			//	remind = 0;
			if (remind > 0 && base > 0 && dif > 0)
			{
				if ((base + 1) * max / dif > base )
					ans = base + 1;
					
			}else
			
			
			if (remind !=0)
			{
				//System.out.println("rem == "+remind+" base =="+base + "max == "+max);
				
				if (remind == min)
					ans ++;
				else
					ans +=2;
			}
			
			System.out.println(ans);
			
		}
		
		
		//return ans;
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
