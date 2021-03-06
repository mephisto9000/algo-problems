import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ConnectedGraph {
	
	
	int m;
	int n;
	int[][] matrix;
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		matrix = new int[m][n];
		
		for (int i = 0; i < m; i++)
		{
			String[] vals = br.readLine().split(" ");
			
			for (int j = 0; j < n; j++)
			{
				matrix[i][j] = Integer.parseInt(vals[j]);
			}
		}
		
		int max = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int tmp = bfs(i,j); 
				
				max = max < tmp? tmp : max;
			}
		}
		
		System.out.println(max);
		
		
		
	}
	
	
	int bfs(int i, int j)
	{
		if (i<0 || j < 0) return 0;
		
		if (i >=m || j >= n) return 0;
		
		
		int ctr = 0;  
		if (matrix[i][j] == 1)
		{
			ctr = 1;
			matrix[i][j] = 0;
			ctr += bfs(i+1, j);
			ctr += bfs(i-1, j);
			ctr += bfs(i, j+1);
			ctr += bfs(i, j-1);
			ctr += bfs(i+1, j+1);
			ctr += bfs(i-1, j-1);
			ctr += bfs(i+1, j-1);
			ctr += bfs(i-1, j+1);
		}
		
		
		return ctr;
	}

	public static void main(String[] args) throws Exception{
		
		ConnectedGraph sol = new ConnectedGraph();
		
		sol.calc();

	}

}
