import java.io.BufferedReader;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.Iterator;

import java.util.LinkedList;

import java.util.List;

public class __Solution {

	Node[] nodes;

	int[][] rGraph;

	Node source;

	Node sink;

	int[] path;
	int pathLen = 0;

	int n;

	public class Node {
		
		List<Node> parent;
		List<Node> children;
		int difficulty;
		int vi;
		 
		public Node(int difficulty, int vi)
		{
			parent = new LinkedList<Node>();
			children = new LinkedList<Node>();
			this.difficulty = difficulty;
			this.vi = vi;
			
		}

		public void addParent(Node n)
		{
			parent.add(n);
		}

		public void addChild(Node n)
		{
			children.add(n);
		}

	}

	public boolean bfs()

	{

		boolean used[] = new boolean[n + 2];

		Arrays.fill(used, false);

		path = new int[n + 2];
		pathLen = 0;

		Arrays.fill(path, -1);

		List<Integer> q = new LinkedList<Integer>();

		q.add(0);
		used[0] = true;
		path[0] = -1;

		while (!q.isEmpty())

		{
			int u = q.remove(0);

			for (int v = 0; v < n + 2; v++)
			{
				if (rGraph[u][v] > 0 && !used[v])

				{
					q.add(v);
					path[v] = u;// .add(v);
					used[v] = true;
					pathLen++;

					if (v == n + 1) // sink
						return true;
				}

			}

		}

		return false;
	}

	public void buildRGraph()
	{
		rGraph = new int[n + 2][n + 2];
		for (int u = 0; u < n + 2; u++)
		{
			Arrays.fill(rGraph[u], 0);
			if (u > 0 && u < n + 1 && nodes[u].parent.isEmpty())

				rGraph[0][u] = 1000000; // Integer.MAX_VALUE;

			if (u < n + 1 && u  > 0 && nodes[u].children.isEmpty())

				rGraph[u][n + 1] = 1; // Integer.MAX_VALUE;

			Node tmp = null;

			if (!nodes[u].children.isEmpty())

				for (Iterator<Node> it = nodes[u].children.iterator(); it.hasNext();)

				{
					tmp = it.next();
					int v = tmp.difficulty;
					rGraph[u][v] = 1;
				}
		}
		Node src = nodes[0];
		Node dst = nodes[n + 1];
		for (int j = 0; j < n; j++)
		{
			// if nodes[j+1]
			Node x = nodes[j + 1];
			if (x.parent.isEmpty())
			{
				src.addChild(x);
				x.addParent(src);
			}
			if (x.children.isEmpty())
			{
				dst.addParent(x);
				x.addChild(dst);
			}
		}
		 
	}

	int maxFlow()

	{

		buildRGraph();
		int maxFlowVal = 0;
		while (bfs())
		{
			int flow =  2000000;
			
			System.out.println("loop");

			for (int v = n+1; v != 0; v = path[v])
			{
				
				int u = path[v];

				System.out.println("here, flow == "+flow+" u="+u+" v="+v);
				
				if (rGraph[u][v] < flow && rGraph[u][v] > 0)
					flow = rGraph[u][v];

			}
			
			System.out.println("flow is "+flow);

			for (int v = n+1; v != 0; v = path[v])

			{

				// if (rGraph[path[i])

				// int v = path.get(i);

				int u = path[v];

				rGraph[u][v] -= flow;

				rGraph[v][u] += flow;

				// if (rGraph[u][v] < flow)

				// flow = rGraph[u][v];

			}

			maxFlowVal += flow;

		}

		return maxFlowVal;

	}

	public void calc() throws Throwable

	{

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br = new BufferedReader(new FileReader("input1.txt"));

		Integer t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++)

		{

			String vals[] = br.readLine().split(" ");

			n = Integer.parseInt(vals[0]);

			int k = Integer.parseInt(vals[1]);

			nodes = new Node[n + 2];

			vals = br.readLine().split(" ");

			nodes[0] = new Node(0, Integer.MIN_VALUE);

			for (int j = 0; j < n; j++)

			{

				// here goes the magic

				Node x = new Node(j + 1, Integer.parseInt(vals[j]));

				nodes[j + 1] = x;

			}

			nodes[n + 1] = new Node(n + 1, Integer.MIN_VALUE);

			for (int j = 0; j < n; j++)

			{

				Node x = nodes[j + 1];

				for (int z = j + 1; z < n; z++)

				{

					Node x1 = nodes[z+1];

					// if (Math.abs((x.vi - x1.vi)) >=k)

					if (compatible(j + 1, z+1, k))

					{

						// x.addChild(x1);

						x.addChild(x1);

						x1.addParent(x);
						
						break;

					}

				}

			}

			System.out.println(maxFlow());

			/*
			 * 
			 * int count = 0;
			 * 
			 * for (int j = n-1; j >= 0; j--)
			 * 
			 * {
			 * 
			 * Node x = nodes[j];
			 * 
			 * if (dfs(x))
			 * 
			 * count++;
			 * 
			 * }
			 * 
			 * 
			 * System.out.println(count);
			 */

		}

	}

	boolean compatible(int u, int v, int k)

	{

		if (u < v && Math.abs(nodes[u].vi - nodes[v].vi) >= k)

			return true;

		else

			return false;

	}

	/*
	 * 
	 * public boolean dfs(Node n)
	 * 
	 * {
	 * 
	 * if (n.visited == true)
	 * 
	 * return false;
	 * 
	 * 
	 * 
	 * for (int i = 0; i < n.parent.size(); i++)
	 * 
	 * {
	 * 
	 * dfs(n.parent.get(i));
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * 
	 * System.out.println("vi == "+n.vi);
	 * 
	 * 
	 * n.visited = true;
	 * 
	 * return true;
	 * 
	 * }
	 */

	public static void main(String[] args) throws Throwable {

		__Solution sol = new __Solution();

		sol.calc();

	}

}