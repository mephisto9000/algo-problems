package Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	public String src = null;
	
	public int calc() throws Exception	
	{
		
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		
		int n = Integer.parseInt(br.readLine());
		
		
		 
		
		
		
		@SuppressWarnings("unchecked")
		PriorityQueue pq = new PriorityQueue(n, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				
				Integer i1 = (Integer) o1;
				Integer i2 = (Integer) o2;
				
				int d1 = process(i1);
				int d2 = process(i2);
				
				if (d1 > d2)
					return -1;
				
				if (d2 > d1)
					return 1;
				
				if (d2 == d1)
				{
					if (i1 < i2)
						return -1;
					else
						return 1;
				}
				
				return 0;
			}
			
		});
		
		
		for (int i = 1; i<= n; i++)		
			if (n % i == 0)
			{
				//System.out.println(i);
				pq.add(i);
			}
		
		Integer ans = (Integer) pq.peek();
		 
		
		return ans;
		
	}
	
	int process(Integer n)
	{
		int ans = 0;
		
		int v = n;
		
		while (v > 0)
		{
			int a = v % 10;
			ans += a;
			v = v / 10;
		}
		
		return ans;
	}

	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
