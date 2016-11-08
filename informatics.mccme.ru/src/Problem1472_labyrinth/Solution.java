package Problem1472_labyrinth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	
	String src = null;
	
	int m; //columns
	int n; //lines
	
	Point [][] mtx;
	
	class Point
	{
		int horizontal = 0;
		int vertical = 0;
		
		int value = 0;
		int distance = 0;
		
		int x;
		int y;
		
		boolean visited = false;
		
		public boolean setVisited()
		{
			if (visited == false)
			{
				visited = true;
				return visited;
			}
			else
				return false;
		}
		
		public Point(int y, int x, int value)
		{
			this.value = value;
			this.x = x;
			this.y = y;
		}
		
		public int setHorizontal()
		{
			if (horizontal == 0)
			{
				horizontal = 1 ;
				
				return 0;
			}
			else
				return -1;
		}
		
		
		public int setVertical()
		{
			if (vertical == 0)
			{
				vertical = 1;
				return 0;
			}
			else
				return -1;
		}
		
		public void setDistance(int distance)
		{
			this.distance = distance;
		}
		
		 
	}
	
	
	public int calc() throws Exception
	{
		
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String[] vals = br.readLine().split(" ");
		
		m = Integer.parseInt(vals[0]);
		n = Integer.parseInt(vals[1]);
		
		
		mtx = new Point[m][n];
		
		for (int i = 0; i < n; i++)
		{
			
			vals = br.readLine().split(" ");
			
			for (int j = 0; j < m; j++)
			{
				mtx[i][j] = new Point(i, j, Integer.parseInt(vals[j]));
			}
		}
		
		int res = rec(0,0);
		
		
		return 0;
		
	}
	
	public int rec(int x, int y)
	{
		/*
		if (mtx[y][x].value == 2)
			return 0;
		
		//moving right
		int ans1 = 0;
		
		while (x+1 < m)
		{
			if (mtx[y][x+1].value == 0 && mtx[y][x+1].setHorizontal() ==0  )
			{
				continue;
			}
			
			if (mtx[y][x+1].value == 1)
			{
				rec(x,y);
			}
			
			
		} */
		
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(mtx[0][0]);
		
		mtx[0][0].setHorizontal();
		mtx[0][0].setVertical();
		mtx[0][0].setDistance(0);
		
		while(!q.isEmpty())
		{
			Point p = q.poll();
			int dist = p.distance;
			
			
			if (p.setVisited() == false)
				continue;
			
			
			if (p.value == 2)
			{
				return p.distance;
			}
			
			
			if (p.vertical == 1  )
			{
				int z = 0;
				
				while(p.x +z +1 < m)
				{
					z++;
					
					if(mtx[p.y][p.x+z].value ==0)
					{
						Point p1 = mtx[p.y][p.x+z];
						p1.setDistance(p.distance);																		
					}
					else
					{
						Point p1 = mtx[p.y][p.x+z-1];
						
						p1.setDistance(p.distance +1);
						p1.setHorizontal();
						q.add(p1);
							
					}
					
				}
				
				z = 0;
				
				while(p.x - z -1 >= 0)
				{
					z++;
					
					if(mtx[p.y][p.x-z].value ==0)
					{
						Point p1 = mtx[p.y][p.x-z];
						p1.setDistance(p.distance);
																		
					}
					else
					{
						Point p1 = mtx[p.y][p.x-z+1];
						
						p1.setDistance(p.distance +1);
						p1.setHorizontal();
						q.add(p1);
							
					}
					
				}
				
			} // if vertical
			
			
			if (p.horizontal == 1)
			{
				int z = 0;
				
				while(p.y +z +1 < n)
				{
					z++;
					
					if(mtx[p.y + z][p.x+z].value ==0)
					{
						Point p1 = mtx[p.y][p.x+z];
						p1.setDistance(p.distance);																		
					}
					else
					{
						Point p1 = mtx[p.y][p.x+z-1];
						
						p1.setDistance(p.distance +1);
						p1.setHorizontal();
						q.add(p1);
							
					}
					
				}
				
				z = 0;
				
				while(p.x - z -1 < m)
				{
					z++;
					
					if(mtx[p.y][p.x-z].value ==0)
					{
						Point p1 = mtx[p.y][p.x-z];
						p1.setDistance(p.distance);
																		
					}
					else
					{
						Point p1 = mtx[p.y][p.x-z+1];
						
						p1.setDistance(p.distance +1);
						p1.setHorizontal();
						q.add(p1);
							
					}
					
				}
			} //if (p.horizontal == 1)
		}
		
		
		return 0;
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
