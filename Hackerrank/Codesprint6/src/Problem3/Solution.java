package Problem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	int n;
	int[][]mtr;
	
	public String calc() throws Exception
	{
		
		BufferedReader br;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		int q = Integer.parseInt(br.readLine());
		
		String[] vals;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < q; i++)
		{
			int ans = 0;
			 n = Integer.parseInt(br.readLine());
			
			mtr = new int[n*2][n*2];
			
			for (int j = 0; j < n*2; j++)
			{
				vals = br.readLine().split(" ");
				for (int k = 0; k < n*2; k++)
				{
					mtr[j][k] = Integer.parseInt(vals[k]);
				}
			
			}
			
			for (int j = 0; j <n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					int mi = 0;
					int mj = 0;
					int max = mtr[j][k];
					
					if (mtr[2*n - j-1][k] > max)
					{
						mi = 2*n - j-1;
						mj = k;
						max = mtr[2*n - j-1][k];
					}
					
					if (mtr[j][2*n-k-1] > max)
					{
						mi =  j;
						mj = 2*n -k-1;
						max = mtr[j][2*n-k-1];
					}
					
					if (mtr[2*n-j-1][2*n-k-1] > max)
					{
						mi = 2*n - j-1;
						mj = 2*n - k-1;
						max = mtr[2*n - j-1][2*n-k-1];
					}
					
					//System.out.println("max =="+max);
					//System.out.println("mtr[j][k] =="+mtr[j][k]);
					if (max >mtr[j][k])
					   exch(j,k, mi,mj);
					
					//System.out.println("--"+mtr[j][k]);
					
					ans += mtr[j][k];
					
					
					
					
					
				}
			}
			
			if (sb.length()  >0)
				sb.append("\n");
			sb.append(ans);
		}
		
		
		
		
		return sb.toString();
	}
	
	void exch(int i1, int j1, int i2, int j2)
	{
		int save = mtr[i1][j1];
		mtr[i1][j1] = mtr[i2][j2];
		mtr[i2][j2] = save;
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
