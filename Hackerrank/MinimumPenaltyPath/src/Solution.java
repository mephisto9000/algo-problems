import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	
	String src = null;
	
	int n; // num of nodes
	int m ; // num of edges
	
	Node[] nodes;
	
	public class Node// implements Comparable
	{
		List<Integer> neighbors;
		List<Integer> costs;
		int id;
		
		boolean visited = false;
		int dist = Integer.MAX_VALUE;
		
		public Node(int id)
		{
			neighbors = new ArrayList<Integer>();
			costs = new ArrayList<Integer>();
			this.id = id;
		}

		/*
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			
			Node out_node = (Node) o;
			
			if (this.visited)
				return 1;
			
			if (out_node.visited)
				return -1;
			
			if (this.dist < out_node.dist)
				return -1;
			if (this.dist > out_node.dist)
				return 1;
			
			return 0;
		} */
	}
	
	
	public class NodeComparator implements Comparator<Node>
	{
	    @Override
	    public int compare(Node x, Node y)
	    {
	        
	    	if (x.visited)
				return 1;
			
			if (y.visited)
				return -1;
			
			if (x.dist < y.dist)
				return -1;
			if (x.dist > y.dist)
				return 1;
			
			return 0;
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
		
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		
		nodes = new Node[n];
		
		for (int i = 0; i < n; i++)
		{
			Node node = new Node(i);
			nodes[i] = node;
			
		}
		
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			
			int u = Integer.parseInt(vals[0]) - 1;
			int v = Integer.parseInt(vals[1]) - 1;
			
			int c = Integer.parseInt(vals[2]);
			
			nodes[u].neighbors.add(v);
			nodes[u].costs.add(c);
			
			nodes[v].neighbors.add(u);
			nodes[v].costs.add(c);
			
		}
		
		vals = br.readLine().split(" ");
		
		int a = Integer.parseInt(vals[0]) - 1;
		int b = Integer.parseInt(vals[1]) - 1;
		
		int res = dijkstra(a, b);
		
			
		
		
		return res;
	}
	
	
	int dijkstra(int a, int b)
	{
		boolean[] visited = new boolean[n];
		
		Arrays.fill(visited, false);
		
		int d[] = new int[n];
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		
		
		///nodes[a].dist = 0;
		d[a] = 0;
		//Queue<Node> q = new PriorityQueue<Node>(10000, new NodeComparator());
		
		//for (int i = 0; i < n; i++)
		//	q.add(nodes[i]);
		
		int ans = -1;
		for (int i = 0; i < n; i++)
		{
			int v = -1;
			
			for (int j = 0; j < n; j++)
			{
				if (visited[j]==false && (v == -1 || d[v] > d[j]))
					v = j;
			}
			
			
			Node node =  nodes[v];
			visited[v] = true;
			//Node node =  q.poll();
			//node.visited = true;
			
			//System.out.println("dist == "+d[v]); // .dist);
			
			//if (node.dist == Integer.MAX_VALUE)
			if (d[v] == Integer.MAX_VALUE)
				break;
			
			for (int k = 0; k < node.neighbors.size(); k++)
			{
				int to = node.neighbors.get(k);
				int cost = node.costs.get(k);
				
				Node out_node = nodes[to];
				
				//if (out_node.dist > (node.dist | cost))
				if (d[to] > ( d[v] | cost))
				{
					//out_node.dist = node.dist | cost;
					d[to] = d[v] | cost;
					
				}
				
				
						
						
			}
			
			//q.add(node);
			
			//q.r
			
			
		}
		
		if (d[b]!= Integer.MAX_VALUE)
			ans = d[b]; //.dist;
		
		return ans;
	}

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
