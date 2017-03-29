import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	String src = null;
	
	public int[] calc() throws Exception
	{
		
		BufferedReader br = null;
		
		if (src != null)		
			br = new BufferedReader(new FileReader(src));
		else
			br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());
		
		int[] ans = new int[t];
		
		Arrays.fill(ans, 1);
		
		for (int i = 0; i < t; i++)
		{
			//number of colors
			int n = Integer.parseInt(br.readLine());
			
			String[] vals = br.readLine().split(" ");
			
			int[] colors = new int[n];
			
			 //base = sum(arr)**(n - 2)
			
			for (int j = 0; j < n; j++)
			{
				colors[j] = Integer.parseInt(vals[j]);
			}
			
			
			if (n == 1)
			{
				ans[i] = funk(colors[n-1]) %1000000007;
				continue;
			}
			
			ans[i] = 0;
			for (int j = 0; j < n; j++)
				ans[i] += colors[j];
			
			ans[i] = (int) Math.pow(ans[i], n-2);
			
			if (ans[i] == 0)
				ans[i] = 1;
			for (int j = 0; j < n; j++)
			{
				
				ans[i] *=  colors[j] *  funk(colors[j]);
			}
			
			ans[i] = ans[i]%1000000007;
			
			
			
		}
		
		return ans;
		
	}
	
	public int funk(int n)
	{
		if (n-2 > 0)
			return (int) Math.pow(n, n-2);
		else
			return 1;
	}
	
	public static int factorial(int n) {
	        int fact = 1; // this  will be the result
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	}
	
	
	
	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();
		
		int ans[] = sol.calc();
		
		for (int i = 0; i < ans.length; i++)			
			System.out.println(ans[i]);

	}

}
