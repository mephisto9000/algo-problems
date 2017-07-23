package С;

import java.util.Scanner;

public class Solution {
	
	int n;
	long s;
	int a[];
	
	class Ans
	{
		public int count;
		public long sum;
	}
	
	public Ans calc() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextLong();
		
		a = new int[n];
		
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		return binSearch();
	}
	
	Ans binSearch()
	{
		int min = 0;
		int max = n;
		
		long sum = 0;
		
		while (max  > min ) //&& max - min > 1
		{
			int x = (max + min) / 2;
			
			sum = binSum(x);
			if (sum > s)
			{
				if (max == x)
					max --;
				else
					max = x;
			}
			else
				if (sum < s)
				{
					if (min == x)
						min++;
					else
						min = x;
				}
			else
			{
				Ans a = new Ans();
				a.count = x;
				a.sum = sum;
				
				return a;
			}
		}
		
		Ans a = new Ans();
		a.count = min;
		a.sum = binSum(min);
		
		if (a.sum > s)
		{
			a.count --;
			a.sum = binSum(a.count);
		}
		
		return a;
	}
	
	long binSum(int x)
	{
		long sum = 0;
		
		for (int i = 0; i < x; i++)
			sum += a[i] + (i+1)*x;
		
		return sum;
	}

	public static void main(String[] args) throws Exception {


		Solution sol = new Solution();
		
		//System.out.println(solc.calc());
		Ans a = sol.calc();
		
		System.out.println(a.count+" "+a.sum);
		

	}

}
