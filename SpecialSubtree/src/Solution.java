import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Solution {
	
	public class Edge implements Comparable
	{
		public int u;
		public int v;
		public int wt;
		
		public Edge(int u, int v, int wt)
		{
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		public int compareTo(Object o) {
			
			Edge other = (Edge) o;
			
			if (this.wt < other.wt)
				return -1;
			
			if (this.wt > other.wt)
				return 1;
			
			if (this.u + this.v + this.wt <  other.u + other.v + other.wt)
				return -1;
			
			if (this.u + this.v + this.wt >  other.u + other.v + other.wt)
				return 1;
						
			return 0;
		}
		
		
	}
	
	int n;
	int[] parent;
	
	public Solution(int n)
	{
		this.n = n;
		
		makeMst();
		
	}
	
	public void makeMst()
	{
		parent = new int[n+1];
		
		for (int i = 0; i <= n; i++)
			parent[i] = i;  
	}
	
	public int find(int x)
	{
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}
	
	public void union(int x, int y)
	{
		int xp = find(x);
		int yp = find(y);
		
		parent[xp] = yp;
	}
	
	
	
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		//BufferedReader br = new BufferedReader (new FileReader ("input1.txt"));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int e = Integer.parseInt(vals[1]);
		
		Edge[] edges = new Edge[e];
		
		Solution sol = new Solution(n);
		
		for (int i = 0; i < e; i++)
		{
			
			vals = br.readLine().split(" ");
			Edge edge = sol.new Edge(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), Integer.parseInt(vals[2]));
			edges[i] = edge;
		}
		
		int result = sol.buildTreeFromEdges(edges);
		
		System.out.println(result);

	}

	private int buildTreeFromEdges(Edge[] edges) {
		
		int res = 0;
		
		List<Edge> edgeList = new LinkedList<Edge>();
		
		for (int i = 0; i < edges.length; i++)
		{
			edgeList.add(edges[i]);
		}
		
		Collections.sort(edgeList);
		
		
		
		for (int i = 0; i < edgeList.size(); i++)
		{
			Edge e = edgeList.get(i);
			int srcTree = find(e.u);
			int destTree = find(e.v);
			
			if (srcTree != destTree)
			{
				union(e.u, e.v);
				res += e.wt;
			}
		}
		
		return res;
		
	}

}
