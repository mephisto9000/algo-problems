package Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	String src = null;
	
	public long calc() throws Exception
	{
		BufferedReader br; 
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String vals[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int p = Integer.parseInt(vals[1]);
		
		int[] arr = new int[n];
		
		vals = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(vals[i]);						
		}
		
		Arrays.sort(arr);
		
		long ans = 0;
		
		int max = 0;
		for (int i = 0; i < n; i++)
		{
			int x = (int) Math.ceil(arr[i] / (float) p);
			
			if (x > max)				
				max = x;
			else
				max += 1;
			
			ans+= max;
			
			//System.out.println(x + " " + max);
			
		}
		
		return ans;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
