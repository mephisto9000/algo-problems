import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution {

	public int d[][];
	int n;
	
	public void setMatrix(int d[][], int n)
	{
		this.d = d;
		this.n = n;
	}
	
	public void algo()
	{
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (d[i][k] < Integer.MAX_VALUE && d[k][j] < Integer.MAX_VALUE)
					{
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
					}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int d[][];
		
		Solution sol = new Solution();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		
		
		String[] vals =  br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int m = Integer.parseInt(vals[1]);
		
		d = new int[n][];
		for (int i = 0; i < n; i++)
		{
			d[i] = new int[n];
			Arrays.fill(d[i], Integer.MAX_VALUE);
			d[i][i] = 0;
		}
		
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			int x = Integer.parseInt(vals[0]);
			int y = Integer.parseInt(vals[1]);
			int r = Integer.parseInt(vals[2]);
			d[x-1][y-1] = r;
			//d[y-1][x-1] = r;
			
		}
		
		sol.setMatrix(d, n);
		sol.algo();
		
		int q = Integer.parseInt(br.readLine());
		//int queries[][] = new int[q][];
		
		//int 
		for (int i = 0; i < q; i++)
		{
			//queries[i] = new int[2];
			vals = br.readLine().split(" ");
			int a = Integer.parseInt(vals[0]);
			int b = Integer.parseInt(vals[1]);
			
			//queries[i][0] = a;
			//queries[i][1] = b;
			
			if (sol.d[a-1][b-1] < Integer.MAX_VALUE)			
				System.out.println(sol.d[a-1][b-1]);
			else
				System.out.println("-1");
		}
		
		
		
	}

}
