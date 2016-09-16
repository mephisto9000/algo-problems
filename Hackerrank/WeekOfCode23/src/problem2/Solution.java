package problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	
	String src = null;
	
	char[][] mtx;
	int n;
	
	long max = 0;
	
	class Point
	{
		int x;
		int y;
		public Point (int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o)
		{
			if (o == null)
				return false;
			
			Point po = (Point) o;
			
			if (this.x == po.x && this.y == po.y)
				return true;
			
			return false;
			
		}
	}
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src ==null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
	    n = Integer.parseInt(br.readLine());
	    n+=2;
		
		mtx = new char[n][n];
		
		for(int i = 0; i< n; i++)
			Arrays.fill(mtx[i], '*');
		
		
		 
		for (int i = 1; i < n-1; i++)
		{
			String s = br.readLine();
			
			for (int j = 1; j < n-1; j++)
				mtx[i][j] = s.charAt(j-1);
		}
		
		for (int i = 0; i< n; i++)
			for (int j = 0; j<n; j++)
				if (mtx[i][j]=='.')
				{
					long v = bfs(i,j);
					
					if (v > max)
					{
						max = v;									
					}
			}
		
		return (int) max; 
																	
	}
	
	long bfs(int src_i, int src_j)
	{
		boolean visited[][] = new boolean[n][n];
		
		for (int i = 0; i< n; i++)
			Arrays.fill(visited[i],  false);
		
		Queue<Point> q = new LinkedList<Point>();
		
		long lmin = Long.MAX_VALUE;
		
		Point src_p = new Point(src_i, src_j);
		visited[src_i][src_j] = true;
		q.add(src_p);
		
		while(!q.isEmpty())
		{
			Point p = q.poll();
									
			boolean terminal = true;
			
			if (mtx[p.x][p.y]=='*')
			{
						
				long dist = (long) Math.ceil((Math.sqrt((src_p.x - p.x )*(src_p.x - p.x ) + (src_p.y - p.y )*(src_p.y - p.y )))) - 1 ;
								
				if (dist < lmin)
					lmin = dist;				
			}
			
			//left // top
			if (p.x > 0 && p.y > 0 && visited[p.x - 1][p.y-1] == false ) 
			{
				Point new_p = new Point(p.x-1, p.y-1);
				q.add(new_p);
				visited[p.x - 1][p.y-1] = true;
				
				
				terminal = false;
			}
			
			//top
			if (   p.y > 0 && visited[p.x ][p.y-1] == false) // && mtx[p.x][p.y-1]=='.'
			{
				Point new_p = new Point(p.x , p.y-1);
				q.add(new_p);
				visited[p.x  ][p.y-1] = true;
				
				terminal = false;
			}
			
			//right /top
			if (p.x < n-1 && p.y > 0 && visited[p.x + 1][p.y-1] == false ) //&& mtx[p.x+1][p.y-1]=='.'
			{
				Point new_p = new Point(p.x+1, p.y-1);
				q.add(new_p);
				visited[p.x + 1][p.y-1] = true;
				
				terminal = false;
			}
			
			//right
			if (p.x < n-1   && visited[p.x + 1][p.y] == false ) //&& mtx[p.x+1][p.y]=='.'
			{
				Point new_p = new Point(p.x+1, p.y);
				q.add(new_p);
				visited[p.x + 1][p.y] = true;
				
				terminal = false;
			}
			
			//right bottom
			if (p.x < n-1 && p.y < n-1 && visited[p.x + 1][p.y + 1] == false) // && mtx[p.x+1][p.y+1]=='.'
			{
				Point new_p = new Point(p.x+1, p.y+1);
				q.add(new_p);
				visited[p.x+1][p.y+1] = true;
				
				terminal = false;
			}
			
			//bottom
			if (p.y < n-1 && visited[p.x][p.y + 1] == false ) //&& mtx[p.x][p.y+1]=='.'
			{
				Point new_p = new Point(p.x, p.y+1);
				q.add(new_p);
				visited[p.x][p.y+1] = true;
				
				terminal = false;
			}
			
			//bottom left
			if (p.x > 0 && p.y < n-1 && visited[p.x-1][p.y + 1] == false ) //&& mtx[p.x-1][p.y+1]=='.'
			{
				Point new_p = new Point(p.x-1, p.y+1);
				q.add(new_p);
				visited[p.x-1][p.y+1] = true;
				
				terminal = false;
			}
			
			//left
			if (p.x > 0   && visited[p.x - 1][p.y] == false ) //&& mtx[p.x-1][p.y]=='.'
			{
				Point new_p = new Point(p.x - 1, p.y);
				q.add(new_p);
				visited[p.x - 1][p.y] = true;
				
				terminal = false;
			}
			
			
			
			
			
		}
		
		
		return lmin;
	}
	
	

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
