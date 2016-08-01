import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	char[][] mtx;
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		mtx = new char[n][n];
		
		for (int i = 0; i < n; i++)
		{
			String s = br.readLine();
			mtx[i] = s.toCharArray();
		}
		
		int res = 0;
		for (int i = 0; i < n; i++)
		{
			int v = 0;;
			for (int j  = 0; j < n; j++)
			{
				for (int z  = j+1; z < n; z++)
				if (mtx[i][j] == 'C' && mtx[i][z]=='C')
					v++;
			}
			
			res += v;
		}
		
		
		for (int i = 0; i < n; i++)
		{
			int v = 0;;
			for (int j  = 0; j < n; j++)
			{
				for (int z  = j+1; z < n; z++)
				if (mtx[j][i] == 'C' && mtx[z][i]=='C')
				//if (mtx[z][j] == 'C')
					v++;
			}
			
			res += v;
		}
		
		System.out.println(res);
	}
	
	
	

	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();
		sol.calc();

	}

}
