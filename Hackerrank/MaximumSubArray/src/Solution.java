import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	
	public String calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		
		StringBuffer ans = new StringBuffer();
		
		for (int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			String vals[] = br.readLine().split(" ");
			
			int arr[] = new int[n];
			
			
			int maxSoFar = Integer.MIN_VALUE;
			int maxHere = 0;
			
			int maxPositive = 0;
			for (int j = 0; j < n; j++)
			{
				int a = Integer.parseInt(vals[j]);
				
				maxHere += a;
				
				if (maxSoFar < maxHere)
					maxSoFar = maxHere;
				
				if (maxHere < 0)
					maxHere = 0;
				
				if (a > 0)
					maxPositive += a;
			}
			
			if (maxSoFar < 0)
				maxPositive = maxSoFar;
			
			if (ans.length() > 0)
				ans.append('\n');
			ans.append(maxSoFar + " " + maxPositive);
			
		}
		
		
		
		return ans.toString();
		
		
	}
	
	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();
		
		String ans = sol.calc();
		
		System.out.println(ans);
		

	}

}
