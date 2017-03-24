import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	public int[] calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src!=null)
			br = new BufferedReader(new FileReader(src));
		else
			br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int[] ans = new int[t];
		
		for (int i = 0; i < t; i++)
		{
			
			
			int n = Integer.parseInt(br.readLine());
			
			int ans1 = 0;
			int ans2 = 0;
			
			String[] vals = br.readLine().split(" ");
			
			int v = 1;
			int v1 = Integer.parseInt(vals[0]);
			
			int z = vals.length;
			
 			int lo = 0;
			int hi = 0;
			for (int j = 1; j < z ; j++)
			{
				 
				
				
				int high_to_low_diff = Math.abs(Integer.parseInt(vals[j-1]) - 1);
				int low_to_high_diff = Math.abs(Integer.parseInt(vals[j]) - 1);
				int high_to_high_diff = Math.abs(Integer.parseInt(vals[j]) - Integer.parseInt(vals[j-1]));
						
				int low_next = max(lo, hi+high_to_low_diff);
				int hi_next = max(hi+high_to_high_diff, lo+low_to_high_diff);
						
				lo = low_next;
				hi = hi_next;
			}
									 			
			ans[i] = max (lo, hi);
			
			
		}
		
		return ans;
	}
	
	int max (int a, int b)
	{
		if (a > b)
			return a;
		else
			return b;
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		int[] ans = sol.calc();
		
		for (int i = 0; i < ans.length; i++)
		{
			System.out.println(ans[i]);
		}

	}

}
