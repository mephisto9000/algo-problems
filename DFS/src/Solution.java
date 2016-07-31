import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Solution {
	
	int m;
	int n;

	int ans[];
	Node nodes[];
	int nodesNum = 0;
	int s = 0;
	
	
	public class Node {
		int idx;
		List<Node> children;
		boolean visited;
		
		public Node(int idx)
		{
			this.idx = idx;
			visited = false;
			children = new LinkedList<Node>();
		}
		
		public void setVisited()
		{
			visited = true;
		}
		
		public boolean isVisited()
		{
			return visited;
		}
		
		public void addNode(Node n)
		{
			
			if (!children.contains(n))
				children.add(n);
		}
		
		public List<Node> getChildren()
		{
			return children;
		}
		
		
	}
	
	public Solution(int m, int n)
	{
		this.m = m;
		this.n = n;
		
		
		
		ans = new int[n];
		Arrays.fill(ans, -1);
		
		nodes = new Node[n];
		
		for (int i  = 0; i < n; i++)
		{
			Node node = new Node(i);
			nodes[i] = node;
		}
		
		
		
	}
	
	public void addEdge(int from , int to)
	{
		
		
		
		Node nfrom = nodes[from];
		Node nto = nodes[to];
		
		
		
	 
		nfrom.addNode(nto);
		nto.addNode(nfrom);
		
		
		
		
	}
	
	public void bfs(int src )
	{
		
		s = src;
		
		List<Node> layer = new LinkedList<Node>();
				
		layer.add(nodes[src]);
		
		int iteration = 0;
		while(!layer.isEmpty())
		{
		List<Node> nextLayer = new LinkedList<Node>();
		
		for (int i = 0; i < layer.size(); i++)
		{
			Node current = layer.get(i);
			if (current.isVisited() == false)
			{
				current.setVisited();
				
				ans[current.idx] = iteration * 6;
				List<Node> currentKids = current.getChildren();
				
				Iterator<Node> it = currentKids.iterator();
				while(it.hasNext())
				{
					Node kid = it.next();
					nextLayer.add(kid);
				}
				
			}
			
			//adj[src]
		}
		
		layer = nextLayer;
		
		iteration ++;
		
		}
		
		 
	}
	
	

	public static void main(String[] args) throws IOException {
		 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++)
		{
			String[] vals = br.readLine().split(" ");
			int n = Integer.parseInt(vals[0]);
			int m = Integer.parseInt(vals[1]);
			Solution sol = new Solution(m, n);
			for (int j = 0; j < m; j++)
			{
				vals = br.readLine().split(" ");
				
				int from = Integer.parseInt(vals[0]);
				int to = Integer.parseInt(vals[1]);
				
				sol.addEdge(from-1, to-1);
				
			}
			int s = Integer.parseInt(br.readLine());
			sol.bfs(s-1);
			sol.print();
		}

	}

	private void print() {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			
			
			if (i != s)
			{
				if (sb.length() > 0)
					sb.append(' ');
				
				sb.append(ans[i]);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
