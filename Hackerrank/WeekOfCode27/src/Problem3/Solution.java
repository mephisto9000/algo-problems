package Problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	char mtxInit[][];
	char mtx1[][];
	char mtx2[][];
	char mtx3[][];
	
	public void calc() throws Exception
	{
		 //StringBuffer sb = new StringBuffer();
		 
		
		int n = 10;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String vals[] = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		int q = Integer.parseInt(vals[1]);
		
		mtxInit = new char[n][n];
		mtx1 = new char[n][n];
		mtx2 = new char[n][n];
		mtx3 = new char[n][n];
		//for (i)
		
		
		int dif1 = 0;
		int dif2 = 0;
		int dif3 = 0;
		
		for (int i = 0; i< n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				//sb.append(xory((i * j)*(i*j)));
				//sb.append(' ');
				//char
				char x = xory((((long)i + 1) * ((long)j + 1))*(((long)i + 1)*((long)j + 1)));
				
				mtxInit[i][j] = x;
				
				mtx1[ j][n - i - 1] = x;
				mtx2[n-i-1][n-j - 1] = x;
				mtx3[n-j-1][i] = x;
				
			}
			//sb.append('\n');
		}
		
		
		for (int i = 0; i< n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (mtxInit[i][j] != mtx1[i][j])
					dif1++;
				if (mtxInit[i][j] != mtx2[i][j])
					dif2++;
				if (mtxInit[i][j] != mtx3[i][j])
					dif3++;
			}
			
		}	
				
		//System.out.println(sb.toString());
		
		for (int i = 0; i < q; i++)
		{
			int v = Integer.parseInt(br.readLine());
			
			int idx = v / 90;
			idx = idx % 4;
			
			switch (idx)
			{
				case 0:
					System.out.println(0);
					break;
				case 1:
					System.out.println(dif1);
					break;
				case 2:
					System.out.println(dif2);
					break;
				case 3:
					System.out.println(dif3);
					break;
					
				
			}
		}
	}
	
	
	char xory(long v)
	{
		if (v == 1)
			return 'Y';
		
		char key[] = { 'Y', 'X', 'Y', 'X', 'X', 'Y' , 'Y'};
		v -= 1;
		
		int idx = (int) (v % 7 );
		
		return key[idx];
		
		
		
	}
	
	long hackonacci(int x)
	{
		if (x == 1)
			return 1;
		if (x == 2)
			return 2;
		if (x == 3)
			return 3;
		
		return 1 * hackonacci(x-1) + 2*hackonacci(x-2) + 3*hackonacci(x-3);
	}

	public static void main(String[] args) throws Exception 
	{
		Solution sol = new Solution();
		
		sol.calc();
		
		

	}

}
