import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	City[] cities;
	boolean[] used;
	List<Integer> topSort;
	
	public class City
	{
		public int pos;
		
		public int freeEdgeNum = 0;
		
		public List<Edge> edges;
		
		public City(int pos)
		{
			this.edges = new LinkedList<Edge>();
			this.pos = pos;
		}
		
		public void addEdge(Edge e)
		{
			edges.add(e);
			freeEdgeNum++;
		}
	}
	
	public class Edge
	{
		public int from;
		public int to;
		
		public Edge(int from, int to)
		{
			this.from = from;
			this.to = to;
		}
		
		public boolean isVisited = false; 
	}
	
	public void calc() throws NumberFormatException, IOException
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < t; i++)
		{
			
			int n = Integer.parseInt(br.readLine().trim());
			
			cities = new City[n];
			used = new boolean[n];
			topSort = new LinkedList<Integer>();
			
			Arrays.fill(used,  false);
			
			for (int j = 0; j < n; j++ )
			{
				cities[j] = new City(j);
				
			}
			
			for (int j = 0; j < n-1; j++)
			{
				String[] vals = br.readLine().trim().split(" ");
				
				int v1 = Integer.parseInt(vals[0]);
				int v2 = Integer.parseInt(vals[1]);
				
				Edge edge = new Edge(v1, v2);
				cities[v1].addEdge(edge);
				
				cities[v2].addEdge(edge);
			}
			
			topSortCall();
			
			//int src = topSort.get(i);
			
			int counter = 0;
			for (int j = 0; j < topSort.size(); j++)
			{
				int src = topSort.get(j);
				
				if (dfs(src, -1) >=1)
					counter ++;
				
			}
			
			System.out.println(counter);
			
			
			
		}
	}
	
	public void dfs2(int v)
	{
		used[v] = true;
		
		//for (int i = 0; i < cities.length; i++)
		//{
			//int to =
		City c = cities[v];
		
		
		for (int i = 0; i < c.edges.size(); i++)
		{
			Edge e = c.edges.get(i);
			
			int to = -1;
			
			if (e.from == v)
				to = e.to;
			else
				to = e.from;
			
			if (!used[to])
				dfs2(to);
			
		}
		
		topSort.add(v);
			
			
		
	}
	
	void topSortCall()
	{
		for (int i = 0; i < cities.length; i++)
		{
			used[i] = false;
			
		}
		
		topSort.clear();
		for (int i = 0; i < cities.length; i++)
		{
			if (!used[i])
				dfs2(i);
		}
		
		//Collections.reverse(topSort);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < topSort.size(); i++)
		{
			sb.append(topSort.get(i));
			sb.append(' ');
		}
		
		System.out.println(sb.toString());
		
			
			
	}
	
	public int dfs(int cityIdx, int fromIdx)
	{
		City c = cities[cityIdx];
		
		//c.edges
		int newCityIdx = -1;
		int currentDepth = 0;
		boolean found = false;
		
		
		
		
		for (Edge e : c.edges)
		{
			if (e.from == fromIdx || e.to == fromIdx)
			{
				e.isVisited = true;
				cities[fromIdx].freeEdgeNum --;
				 
			}

				
			
			
			if (e.isVisited == false)
			{
				
				int tempCityIdx;
				if (e.from == cityIdx)
				   tempCityIdx = e.to;
				else
				   tempCityIdx = e.from;
				
				
				if (newCityIdx == -1)
					newCityIdx = tempCityIdx;
				else
				if (cities[tempCityIdx].edges.size() > cities[newCityIdx].edges.size())
					newCityIdx = tempCityIdx;
				
				if (cities[tempCityIdx].freeEdgeNum == 1)					
				{					
					e.isVisited = true;		
					cities[tempCityIdx].freeEdgeNum --;
					
				}
				
				found = true;
			}
			else
				continue;
			
			
			
			//if (dfs[newCityIdx] > 1)
			
			if (currentDepth == 0)
			{
			int depth = dfs(newCityIdx, cityIdx);
			
			if (depth >= 1)
			{
				currentDepth += depth;
			//	break;
			}
			}
		}
		
		if (found == false)
			return 0;
		
		return currentDepth + 1;
	}
	
	
	
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		
		sol.calc();
		
		

	}

}
