import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		int [][] mtx = new int[n][n];
		
		for (int i = 0; i < n; i++)
		{
		String[] st = br.readLine().split(" ");
		for (int j = 0; j < n; j++)
		mtx[i][j] = Integer.parseInt(st[j]);
		}
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					if (mtx[i][j] > mtx[i][k] + mtx[k][i])
						
				}
			}
		}
		
	}
	

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		sol.calc();

	}

}
