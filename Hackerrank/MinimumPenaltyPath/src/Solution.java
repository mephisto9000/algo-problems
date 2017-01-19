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
	int maxCost = 2047;
	
	Node[] nodes;
	
	
	public class Pair
	{
		int nodeIdx;
		int cost;
		
		public Pair(int i, int c)
		{
			nodeIdx = i;
			cost = c;
		}
	}
	
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
		
		int res = bfs(a, b);
		
			
		
		
		return res;
	}
	
	
	int bfs(int a, int b)
	{
		boolean[][] visited = new boolean[n][maxCost];
		
		for (int i = 0; i < n; i++)
			Arrays.fill(visited[i], false);
		
		int d[] = new int[n];
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		Pair src = new Pair (a, 0);
		
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.add(src);
		
		while (!q.isEmpty())
		{
			Pair p = q.poll();
			
			for (int j = 0; j < nodes[p.nodeIdx].neighbors.size(); j++)
			{
				int nidx = nodes[p.nodeIdx].neighbors.get(j);
				int ncost = nodes[p.nodeIdx].costs.get(j);
				
				if (!visited[nidx][ncost | p.cost ])
				{
					visited[nidx][ncost | p.cost ] = true;
					
					Pair pnew = new Pair(nidx, ncost | p.cost);					
					q.add(pnew);
				}
			}
			
		}
		
		int ans = -1;
		for (int j = 0; j < maxCost; j++)
		{
			if (visited[b][j]) 
			{
				ans = j;
				break;
			}
		}
		 
		return ans;
	}

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
