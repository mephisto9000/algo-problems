import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	char[][] matrix;
	boolean [][] visited;
	int m; 
	int n;

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int t = Integer.parseInt(br.readLine());
		
		String vals[] ;
		
		
		
		
		
		for (int k = 0; k < t; k++)
		{
			vals = br.readLine().split(" ");
			
			m = Integer.parseInt(vals[0]);
			n = Integer.parseInt(vals[1]);
			
			matrix = new char[m][n];
			
			
			
			
			
			int sI = 0;
			int sJ = 0;
			int dI = 0;
			int dJ = 0;
			
			
			
			for (int i = 0; i < m; i++)
			{
				String s = br.readLine();
				for (int j = 0; j < n; j++)
				{
					char v = s.charAt(j);
					
					matrix[i][j] = v;
					
					if (v == 'M')
					{
						sI = i;
						sJ = j;
					}
					else
					if (v == '*')
					{
						dI = i;
						dJ = j;
					}
										
				}
												
			}
			
			visited = new boolean[m][n];
			
			for (int i = 0; i < m; i++)
			{
				Arrays.fill(visited[i], false);
			}
			
			int l = Integer.parseInt(br.readLine());
			
			
			int result = countLuck(sI, sJ, dI, dJ, l, 0);
			
			if (result == l)
				System.out.println("Impressed");
			else
				System.out.println("Oops!");
									
		}
		
		
		
		
	}
	
	int countLuck(int sI, int sJ, int dI, int dJ, int luck, int luckSoFar)	
	{
		if (sI == dI && sJ == dJ)
		{
			visited[dI][dJ] = true;
			return 0;
		}
		
		if (visited[sI][sJ] == true)
			return -1;
		
		visited [sI][sJ] = true;
		
		int result1 = -1;
		int result2 = -1;
		int result3 = -1;
		int result4 = -1;
		int ways = -1;
		
		if (sI -1 >= 0 && visited[sI-1][sJ] == false && (matrix[sI - 1][sJ] == '.' || matrix[sI - 1][sJ] == '*'))
		{
			ways ++;
			result1 = countLuck(sI-1, sJ, dI, dJ, luck, luckSoFar);
		}
		
		if (sI +1 < m && visited[sI+1][sJ] == false && (matrix[sI + 1][sJ] == '.' || matrix[sI + 1][sJ] == '*'))
		{
			ways ++;
			result2 = countLuck(sI+1, sJ, dI, dJ, luck, luckSoFar);
		}
		
		if (sJ - 1 >= 0 && visited[sI][sJ- 1] == false && (matrix[sI][sJ - 1] == '.' || matrix[sI][sJ - 1] == '*'))
		{
			ways ++;
			result3 = countLuck(sI, sJ - 1, dI, dJ, luck, luckSoFar);
		}
		
		if (sJ + 1 < n && visited[sI][sJ + 1] == false && (matrix[sI][sJ + 1] == '.' || matrix[sI][sJ + 1] == '*'))
		{
			ways ++;
			result4 = countLuck(sI, sJ + 1, dI, dJ, luck, luckSoFar);
		}
		
		visited [sI][sJ] = false;
		
		if (ways == 0)
			return max4(result1, result2, result3, result4);
		else
			return max4(result1, result2, result3, result4) + 1; 
		
		
		
		
	}
	
	int max4(int a, int b, int c, int d)
	{
		int x;
		int y;
		
		if (a > b)
			x = a;
		else
			x = b;
		
		if (c > d)
			y = c;
		else
			y = d;
		
		if (x > y)
			return x;
		else
			return y;
			
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		sol.calc();
		
		

	}

}
