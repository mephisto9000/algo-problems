import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {

	
	int[][] g;
	int n;
	int m;
	int start = 0;
	
	public Solution(int n, int m) {
		this.n = n;
		this.m = m;
		
		g = new int [n][n];
		for (int i = 0; i < n; i++)
		{
			g[i] = new int[n];
			Arrays.fill(g[i], Integer.MAX_VALUE);
		}
	}
	
	public void addEdge(int x, int y, int r)
	{
		g[x-1][y-1] = r;
		g[y-1][x-1] = r;
	}
	
	public void addStart(int start)
	{
		this.start = start;
	}



	public int calc()
	{
		
		int result = 0;
		
		boolean[] used = new boolean[n];
		int[] min_e = new int[n];
		int[] sel_e = new int[n];
						
		
		Arrays.fill(used,  false);
		Arrays.fill(min_e, Integer.MAX_VALUE);
		Arrays.fill(sel_e, -1);
		
		min_e[start - 1] = 0;  
		for (int i = 0; i < n; ++i)
		{
			int v = -1;
			
			for (int j = 0; j < n; j++)
			{
				if (!used[j] && (v == -1 || min_e[j] < min_e[v]))
					v = j;
			}
			
			if (min_e[v] == Integer.MAX_VALUE)
			{
				//System.out.println("no mst!");
				return -1;
			}
			
			used[v] = true;
			
			if (sel_e[v] != -1)
				result += g[v][sel_e[v]];
				//cout << v << " " << sel_e[v] << endl;
				
			for (int to = 0; to < n; to++)	
			{
				if (g[v][to] < min_e[to])
				{
					min_e[to] = g[v][to];
					sel_e[to] = v;
				}
			}
			
			
			
			
			
			
			
		
		}
		
		 
		
		return result;
		
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Solution sol = new Solution (n, m);
		
		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			sol.addEdge(x, y, r);
			
		}
		
		int start = Integer.parseInt(br.readLine());
		
		sol.addStart(start);
		
		System.out.println(sol.calc());
						
	}

}
