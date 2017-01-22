import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	
	public int[] calc() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int t = Integer.parseInt(br.readLine());
		
		int ans[] = new int[t];
		for (int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			
			int[] colleagues = new int[n];
			
			String[] vals = br.readLine().split(" ");
			
			int ops = 0;
			
			int shift = 0;
			
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++)
			{
				colleagues[j] = Integer.parseInt(vals[j]);
				
				if (colleagues[j] < min)
					min = colleagues[j];
			}
			
			
			Arrays.sort(colleagues);
			
			for (int j = n-1; j >0; j--)
			{
				while(colleagues[j-1] + shift < colleagues[j] )
				{
					int dif =  colleagues[j] - colleagues[j-1] - shift;
					
					if (dif >= 5)
					{
						shift += 5;
						ops++;
					}
					else					
					if (dif >= 2)
					{
						shift += 2;
						ops++;
					}
					else
					if (dif >= 1)
					{
						shift += 1;
						ops++;
					}
						
				}
				
				colleagues[j-1] += shift;
			}
			
			ans[i] = ops;
			
			
		}
		
		return ans;
	}

	public static void main(String[] args) throws Exception  {
		

		Solution sol = new Solution();
				
		int []ans = sol.calc();
		for (int i = 0; i < ans.length; i++)
		{
			System.out.println(ans[i]);
		}
			

	}

}
