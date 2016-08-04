import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;




public class Solution {
	
	int stations = 0;
	int connections = 0;
	List<Edge> edges;
	int edgesSoFar = 0;
	
	int d[];
	boolean u[];
	
	
	public class DSU
	{
		public int[] parent;
		public int[] price;
		
		public DSU(int n)
		{
			//System.out.println("n == "+n);
			parent = new int[n+1];
			price = new int[n+1];
			
			for (int i = 0; i < n+1; i++)
			{
				parent[i] = i;
				price[i] = 0;
			}
			
			
		}
		
		public int find(int n)
		{
			if (parent[n] == n)
				return n;
			
			return find(parent[n]);
		}
		
		public void union(int x1, int x2, int edgePrice)
		{
			int y1 = find(x1);
			int y2 = find(x2);
			
			int p1 = price[y1];
			int p2 = price[y2];
			
			
			
			if (y1 >= y2)
				parent[y1]= y2;
			else
				parent[y2]= y1;
				
			
			if (edgePrice > price[y2] && edgePrice > price[y1])
			{
				price[y2] = edgePrice;
				price[y1] = edgePrice;
			}
		}
	}
	
	public Solution(int numberOfStations, int numberOfConnections)
	{
		stations = numberOfStations;
		connections = numberOfConnections;
		edges = new ArrayList<Edge>();
		
		
		d = new int[stations];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[0] = 0;
		
		u = new boolean[stations];
		Arrays.fill(u,  false);
		
		
		
		
	}
	
	
	int calc()
	{
		int n = stations;
		
		
		
		Collections.sort(edges);
		
		DSU dsu = new DSU(stations);
		
		
		
		
		
		Iterator it = (Iterator) edges.iterator();
		
		
		while (it.hasNext())
		{
			
			
			Edge e = (Edge) it.next();
			
			int dsu1 = dsu.find(e.source);
			int dsu2 = dsu.find(e.dest);
			
			
			
			if(dsu1 != dsu2)
			{
				dsu.union(e.source, e.dest, e.price);
				
				
					
					int f = dsu.find(stations);
					
					int f1 = dsu.find(1);
					
					
					
					if (f == f1)
						
						return dsu.price[f1];
				
			}
		}
		
		
		
		return (d[n-1]);
	}
	
	public void addConnection(int source, int dest, int price)
	{
		
		
		Edge e = new Edge(source, dest, price);
		
		edges.add(e);
		
		edgesSoFar++;
		
		
		
	}
	
	
	public class Edge implements Comparable
	{
		int source;
		int dest;
		int price;
		
		public Edge(int source, int dest, int price)
		{
			super();
			this.source = source;
			this.dest = dest;
			this.price = price;
		}

		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			//if (o.
			Edge edge = (Edge) o;
			
			if (edge.price > price)
				return -1;
			
			if (edge.price < price)
				return 1;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s);
		
		int sourceCity = 0;
		int destCity = 0;
		int numberOfStations = 0;
		int numberOfConnections = 0;
		
		
		
		
		numberOfStations = Integer.parseInt(st.nextToken());
		numberOfConnections = Integer.parseInt(st.nextToken());
		
		Solution sol = new Solution(numberOfStations, numberOfConnections  );
		
		for (int i = 0; i < numberOfConnections; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());					
			int price = Integer.parseInt(st.nextToken());
			
			
			sol.addConnection(from,  to,  price); 
			
		}
		
		int val = sol.calc();
		
		if (val != Integer.MAX_VALUE)
			System.out.println(val);
		else
			System.out.println("NO PATH EXISTS");
		

	}

}
