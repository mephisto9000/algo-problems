import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	long[][] mtx;
	int n; int m;
	
	boolean transpose = false;
	
	public void calc() throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input3.txt"));
		
		String vals[]  = br.readLine().split(" ");
		
		 n = Integer.parseInt(vals[0]);
		 m = Integer.parseInt(vals[1]);
		int k = Integer.parseInt(vals[2]);
		
		
		if (n > m)
		{
			transpose = true;
			int t = m;
			m = n;
			n = t;
		}
		
		mtx = new long[n][m];
		
		for (int i = 0; i < n; i++)
			Arrays.fill(mtx[i], 0);
		
		for (int i = 0; i < k; i++)
		{
			vals  = br.readLine().split(" ");
			
			int mode = Integer.parseInt(vals[0]);
			int idx = Integer.parseInt(vals[1]);
			long color = Integer.parseInt(vals[2]);
			
			if (transpose)
				mode = 3 - mode;
			
			switch (mode)
			{
			case 1:
				
				fillHoriz(idx-1, color);
				break;
			case 2 :
				fillVert(idx-1, color);
				break;
			}
			
		}
		
		
		if (! transpose)
		for (int i = 0; i < n; i++)
		{
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < m; j++)
			{
				sb.append(mtx[i][j]);
				sb.append(' ');
			}
			System.out.println(sb.toString().trim());
		}
		else
		{
			for (int j = 0; j < m; j++)
			
			{
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < n; i++)
				{
					sb.append(mtx[i][j]);
					sb.append(' ');
				}
				System.out.println(sb.toString().trim());
			}
		}
				
		
		
	}
	
	public void fillHoriz(int idx, long color)
	{
		Arrays.fill(mtx[idx], color);
	}
	
	public void fillVert(int idx, long color)
	{
		for (int i = 0; i < n; i++)
			mtx[i][idx] = color;
	}

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		sol.calc();

	}

}
