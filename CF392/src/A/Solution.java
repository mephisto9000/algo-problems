package A;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public  int calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		int[] arr = new int[n];
		
		String[] vals = br.readLine().split(" ");
		
		int max = 0;
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(vals[i]);
			
			if (max < arr[i])
				max = arr[i];
			
		}
		
		
		int ans = 0;
		for (int i = 0; i < n; i++)
		{
			ans += (max - arr[i]);
		
		}
		
		
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
