import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
	
	public class Edge
	{
		public int source;
		public int dest;
		public int price;
		
		public Edge(int source, int dest, int price)
		{
			this.source = source;
			this.dest = dest;
			this.price = price;
		}
	}
	
	int[] d;
	boolean[] u;
	
	List[] edges;
	
	public Solution(int vertexNum)
	{
		int n = vertexNum;
		
		d = new int[n];
		u = new boolean[n];
		
		Arrays.fill(d,  Integer.MAX_VALUE);
		Arrays.fill(u,  false);
		
		edges = new List[n * 2];
		//for (int i = 0; i < )
		
		
	}
	
	public void setSource(int source)
	{
		d[source-1] = 0;
	}
	
	public void addEdge(int source, int dest, int price)
	{
		if (edges[source-1] == null)
			edges[source-1] = new LinkedList();
		
		if (edges[dest-1] == null)
			edges[dest-1] = new LinkedList();
		
		Edge e1 = new Edge(source, dest, price);
		Edge e2 = new Edge(dest, source, price);
		edges[source-1].add(e1);
		edges[dest-1].add(e2);
	}
	
	public void calc()
	{
		int n = d.length;
		
		for (int i = 0; i < n; ++i)
		{
			int v = -1;
			for (int j = 0; j < n; ++j)
			{
				if (u[j] == false && (v == -1 || d[j] < d[v]))
					v = j;
			}	
				u[v] = true;
				
				if (d[v] == Integer.MAX_VALUE)
					break;
				
				for (int k = 0; k < edges[v].size(); k++)
				{
					Edge e = (Edge) edges[v].get(k);
					
					int to = e.dest-1;
					
					if (d[to] > d[v] + e.price)
					{
						d[to] = d[v] + e.price;
					}
				
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			if (d[i] != 0)
			{
				//if (d[i] ==
				if (sb.length() > 0)
				sb.append(' ');
				
				if (d[i] == Integer.MAX_VALUE)
					sb.append(-1);
				else
					sb.append(d[i]);
			}
				
			
		}
		
		System.out.println(sb.toString());
	}
	

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br.readLine();

		// num of testcases
		int t_total  = Integer.parseInt( br.readLine());
		for (int t = 0; t < t_total; t++ )
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// num of nodes
			int n = Integer.parseInt(st.nextToken());
			// num of edges
			int m = Integer.parseInt(st.nextToken());
			
			Solution sol = new Solution(n); 
			
			for (int i = 0; i < m; ++i)
			{
				st = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				int price = Integer.parseInt(st.nextToken());
				
				sol.addEdge(src, dest, price);
				
			}
			
			sol.setSource(Integer.parseInt(br.readLine()));
			
			sol.calc();
			
		}
	}

}
