package attempt1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution {

	int[] digits;
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
				
		
		String[] vals = br.readLine().split(" ");
		digits = new int[vals.length];
		
		for (int i = 0; i < vals.length; i++)
		{
			digits[i] = Integer.parseInt(vals[i]);
		}
		
		Arrays.sort(digits);
		
		
		for (int i = 0; i < digits.length/2; i++)
		{
			swap(i, digits.length-1-i);
		}
		
		int n = digits.length;
		
		while(true)
		{
			
			print();
			
			boolean stop = true;
			for (int j = n-1; j > 0; j--)	
			{
				if (digits[j-1] > digits[j])
				{
					
					stop = false;
					int minR = j;
					for (int k = j+1; k < n; k++)
					{
						if (digits[k] > digits[minR] && digits[k] < digits[j-1])
						{
							minR = k;
						}
					}
					
					swap(j-1, minR);
					
					int to = (j + n) / 2;
					int z = 0;
					for (int k = j; k < to; k++ )
					{
						
						swap (k, n-1-z);
						z++;
					}
					
					break;
				}
				
				
			}
			
			
			
			if (stop)
				break;
		}
		
		
		
		
		
	}
	
	
	public void print()
	{
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < digits.length; i++)
		{
			sb.append(digits[i]);
			sb.append(' ');
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public void swap(int i, int j)
	{
		if (i != j)
		{
			int v = digits[j];
			digits[j] = digits[i];
			digits[i] = v;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
