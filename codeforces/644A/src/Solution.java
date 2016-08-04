import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int a = Integer.parseInt(vals[1]);
		int b = Integer.parseInt(vals[2]);
		
		int party1 = Math.floorDiv(n, 2);
		int party2;
		if (party1 * 2 != n)
			party2 = party1 +1 ;
		else
			party2 = party1;
		
		Stack pstack1 = new Stack();
		Stack pstack2 = new Stack();
		
		Stack pstack11 = new Stack();
		Stack pstack22 = new Stack();
		
		for (int i  = 1; i <= n; i++)
		{
			if (isEven(i))
			{
				pstack1.push(i);
				pstack11.push(i);
			}
			else
			{
				pstack2.push(i);
				pstack22.push(i);
			}
		}
			
		
		
		
		
		
		
		int [][] mtx = new int[a][];
		
		for (int i = 0; i < a; i++)
		{
			mtx[i] = new int[b];
			
			Arrays.fill(mtx[i], 0);
		}
		
		int z = 1;
		for (int i = 0; i < a; i++)
		{
			if (isEven(i+1))
				z = 1;
			else
				z = 2;
			
			for (int j = 0; j < b; j++)
			{
				if (isEven(z))
				{
					if (!pstack1.isEmpty())
					{
						int v = (Integer)pstack1.pop();
						mtx[i][j] = v;
					}
				}
				else
					if (!pstack2.isEmpty())
					{
						int v = (Integer)pstack2.pop();
						mtx[i][j] = v;
					}
			}
			
				
		}
		
		if (pstack1.isEmpty() && pstack2.isEmpty())
		{
			printMatrix(mtx, a, b);
			
			return;
		}
		
		for (int i = 0; i < a; i++)
		{		
			
			Arrays.fill(mtx[i], 0);
		}
		
		 //z = 2;
		for (int i = 0; i < a; i++)
		{
			if (isEven(i+1))
				z = 2;
			else
				z = 1;
			
			for (int j = 0; j < b; j++)
			{
				if (isEven(z))
				{
					if (!pstack11.isEmpty())
					{
						int v = (Integer)pstack11.pop();
						mtx[i][j] = v;
					}
				}
				else
					if (!pstack22.isEmpty())
					{
						int v = (Integer)pstack22.pop();
						mtx[i][j] = v;
					}
			}
			
				
		}
		
		if (pstack11.isEmpty() && pstack22.isEmpty())
		{
			printMatrix(mtx, a, b);
			
			return;
		}
		
		System.out.println("-1");
		
		
		
	}
	
	
	void printMatrix(int [][] mtx, int a, int b)
	{
		for (int i = 0; i < a;i++)
		{
			StringBuffer sb = new StringBuffer();
			
			for (int j = 0; j < b; j++)
			{
				sb.append(mtx[i][j]);
				sb.append(" ");
			}
			
			System.out.println(sb.toString().trim());
		}
	}
	
	public boolean isEven(int v)
	{
		if (v % 2 == 0)
			return true;
		else
			return false;
	}
	
	public boolean isOdd(int v)
	{
		return !isEven(v);
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		sol.calc();
	}

}
