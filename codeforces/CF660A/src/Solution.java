import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	
	
	public void calc() throws Exception
	{
		
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String vars[]  = br.readLine().split(" ");
		
		int n = Integer.parseInt(vars[0]);
		int m = Integer.parseInt(vars[1]);
			
		int[][] bus = new int[n][4];
		
		for (int i = 0; i < n; i++)
		{
			Arrays.fill(bus[i], 0);
		}
		
		//int j =
		int []rp = {1,4,2,3};
		
		int r = 0;
		int rpidx = 0;
		

		boolean out_row = true;
		
		for (int i = 1; i <= m; i++)
		{
			bus[r][rp[rpidx]-1] = i;
			
			rpidx ++;
			
			if (out_row)
			{
			
			if (rpidx == 2)
			{
				rpidx = 0;
				r++;
			}
			
			if (r == n)
			{
				r = 0;
				out_row = false;
				rpidx = 2;
			}
			}
			else
			{
				if (rpidx == 4)
				{
					rpidx = 2;
					r++;
				}
				
				if (r == n)
				{
					r = 0;
					out_row = false;
				}
			}
			
			
		}
		
		int []rp_out = {2,1,3,4};
		
		//int rpidx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < 4; j++)
			if (bus[i][rp_out[j]-1] > 0)
			{
				sb.append(bus[i][rp_out[j]-1]);
				sb.append(' ');
			}
				
		}
		
		System.out.println(sb.toString().trim());
		
		
		
	}
	

	public static void main(String[] args) throws Exception{

		
	Solution sol = new Solution();
	
	sol.calc();

	}
	
	
	

}
