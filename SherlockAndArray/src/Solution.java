import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++)
		{
			int t = Integer.parseInt(br.readLine());
			
			String vals[] = br.readLine().split(" ");
			
			int ivals[] = new int[t];
			int sum1 = 0;
			int sum2 = 0;
			
			for (int j = 0; j < t; j++)
			{
				ivals[j] = Integer.parseInt(vals[j]);
				sum2 += ivals[j];
				
			}
			
			boolean ok = false;
			if (t >0)
			{
			for (int j = 0; j < t; j++)
			{
				
				sum2 -= ivals[j];
				
				if (sum1 == sum2)
				{
					System.out.println("YES");
					ok = true;
					continue;
					
				}
				
				sum1 += ivals[j];
			}
			
			}
			
			if (!ok)
			System.out.println("NO");
			
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {


		Solution sol = new Solution();
		sol.calc();

	}

}
