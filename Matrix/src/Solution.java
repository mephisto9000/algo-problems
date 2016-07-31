import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;




public class Solution {
	
	public class DisjointSets{
		
		private int size;
		private int[] parent;
		private int[] machines;
		private int[] cost;
				
		public DisjointSets(int size)
		{
			
			this.size = size;
			parent = new int[size];
			
			machines = new int[size];
			cost = new int[size];
			
			for (int i = 0; i< size; i++)
			{
				parent[i] = i;
				
				machines[i] = -1;
			}
			
			
		}
		
		public int find(int x)
		{
			if (parent[x] == x)
				return x;
			
			parent[x] = find(parent[x]);
			return parent[x];
		}
		
		public void union (int x1, int x2)
		{
			int y2 = find(x2);
			int y1 = find(x1);
						
			parent[y1] = y2;
			
			if (machines[y1] != -1)
				machines[y2] = machines[y1];
						
		}
		
		
		public int hasMachine(int x1)
		{
			int x = find(x1);
			return machines[x];
		}
		
		public void addMachine(int x1, int machineNum)
		{
			int x = find(x1);
			machines[x] = machineNum;
		}
		
	}
	
	public class Edge implements Comparable{
		int x1;
		int x2;
		int weight;
		
		public Edge(int x1, int x2, int weight)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.weight = weight;
		}

		public int compareTo(Object o) {
			
			if (weight < ((Edge)o).weight)
				return 1;
			if (weight > ((Edge)o).weight)
				return -1;
			
			return 0;
		}

	}
	
	public class Node {
		List edges;
		
		public Node() {
			edges = new LinkedList();
		}
		
		public void addEdge(Edge e)
		{
			edges.add(e);
		}
		
		public Edge getEdge(int i)
		{
			return (Edge)edges.get(i);
		}
	}
	
	public int calc(int size, List<Edge> edgelist, HashSet<Integer> machineset)
	{
		Collections.sort(edgelist);
		
		Iterator it = (Iterator) edgelist.iterator();
		
		DisjointSets djs = new DisjointSets(size);
		
		int cost = 0;
		int components = 0;
				
		
		Iterator mit= machineset.iterator();
		
		
		while (mit.hasNext())
		{
			int machineNum = (Integer)mit.next();
			djs.addMachine(machineNum, machineNum);
		}
		
		int totalWeight = 0;
		while (it.hasNext())
		{
			Edge e = (Edge) it.next();
			
			totalWeight += e.weight;
																						
			if(djs.find(e.x1) == djs.find(e.x2))
				continue;
						
			{
							
				int inFirst = djs.hasMachine(e.x1);
				int inSecond = djs.hasMachine(e.x2);
				
				if (inFirst == -1 || inSecond == -1 || inFirst == inSecond)
				{
									
					djs.union(e.x1, e.x2);
												
					cost += e.weight;
				}
				
			}

		}
		
		return totalWeight - cost;
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		
		List<Edge> edgelist = new LinkedList<Edge>();		
		HashSet<Integer> machineset = new HashSet<Integer>();
		
		Solution sol = new Solution();
		for (int i = 0; i < (n -1) ; i++)
		{
			str = br.readLine();
			st = new StringTokenizer(str);
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Edge edge = sol.new Edge(x1, x2, weight);
			edgelist.add(edge);
		}
		
		for (int i = 0; i < k; i++)
		{			
			str = br.readLine();
			machineset.add(Integer.parseInt(str));
		}
		
		System.out.println(sol.calc(n, edgelist, machineset));
						
	}

}
