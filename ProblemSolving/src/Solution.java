import java.io.BufferedReader;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;

import java.util.LinkedList;

import java.util.List;

public class Solution {

	Node[] nodes;

	//int[][] rGraph;

	//Node source;

	//Node sink;

	int[] path;
	int pathLen = 0;

	

	int n; // число вершин в доле 1
	//int k; // число вершин в доле 2
	
	boolean[] used;
	List[] g; // списки ребер из вершины i первой доли
	
	List<Integer> mt; // maximum matching (максимальное паросочетание)
	// номер вершины в доле 2, связанный с вершиной i в доле 1 (если -1 то связи нет)
	

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

	
	
	 
	boolean try_kuhn(int v) {
		
		if (used[v]) 
			return false;
		
		used[v] = true;
		
		//for (int i = 0; i < g[v].size(); ++i)
		for (int i = 0; i < nodes[v].children.size(); ++i)
		{
			//int to = (int) g[v].get(i);
			
			Node child = nodes[v].children.get(i);
			
			int to = child.difficulty - 1;
			
			int dest = mt.get(to);
			
			if (dest== -1 || try_kuhn (dest)) {
				mt.set(to, v);
				return true;
			}
		}
		
		return false;
			
	}
	
	boolean dfs(int v)
	{
		if (used[v] == true)
			return false;
		
		used[v] = true;
		int to = mt.get(v);
		if (to != -1)
			dfs(to);
			
		return true;
		
	}

	public void calc() throws Throwable

	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));

		Integer t = Integer.parseInt(br.readLine());

		
		//System.out.println("t == "+t);
		for (int i = 0; i < t; i++)

		{

			String vals[] = br.readLine().split(" ");

			n = Integer.parseInt(vals[0]);
			
			
			
			mt = new ArrayList<Integer>();
			
			used = new boolean[n];
			//for (int i = 0; i < n; i++)
			Arrays.fill(used,false);
			
			

			int k = Integer.parseInt(vals[1]);
			
			

			nodes = new Node[n];

			vals = br.readLine().split(" ");

			nodes[0] = new Node(0, Integer.MIN_VALUE);

			for (int j = 0; j < n; j++)

			{
				
				mt.add(-1);
				

				// here goes the magic

				Node x = new Node(j + 1, Integer.parseInt(vals[j]));

				nodes[j] = x;

			}

			//nodes[n ] = new Node(n + 1, Integer.MIN_VALUE);

			for (int j = 0; j < n; j++)

			{

				Node x = nodes[j ];

				for (int z = j + 1; z < n; z++)
				{
					Node x1 = nodes[z];

					if (compatible(j , z, k))
					{
						x.addChild(x1);
						x1.addParent(x);
						//break;

					}
				}
			}
			
			/*
			for (int j = 0; j < n; j++)
			{
				System.out.println(j+" has "+nodes[j].children.size()+" children");
			}*/
			
			
			
			
			
			for (int v = 0; v < n; ++v)
			{
				//used[v] = false;
				Arrays.fill(used, false);
				
				try_kuhn(v);
					
			}
			
			Arrays.fill(used, false);
			int result = 0;
			for (int v = n-1; v >= 0; v--)
			{
				if (dfs(v))
				{
					result ++;
				}
				/*
				else
				if (mt.get(v)== -1 && !dfs(v))
				{
					result ++;
				}*/
					
					
			}
			//System.out.println("result == "+result);
			System.out.println(result);
			
			
			/*
			for (int j = 0; j< n; j++)
				if (mt.get(j) != -1)
					System.out.println(String.format("%d %d", mt.get(j), j));
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

		Solution sol = new Solution();

		sol.calc();

	}

}