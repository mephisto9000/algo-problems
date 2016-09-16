
//package problem165;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//import problem165.Solution.Node;

public class Solution {
	
	public String src = null;
	
	int n = 0; // num of vip guys
	int m = 0; // num of pairs
	
	public Node[] nodes;
	
	public class Node{
		Map<Integer, Node> neighbors = null;
		public int idx;
		public int table = 0;
		
		public Node(int idx)
		{
			this.idx = idx;
			neighbors = new HashMap<Integer, Node>();
		}
		
		public void addNode(Node node)
		{
			//neighbors.add
			if (!neighbors.containsKey(node.idx))
				neighbors.put(node.idx, node);			
		}
		
		
		
	}
	
	public String calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		
		String vals[] = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		
		nodes = new Node[n + 1];
				
		for (int i = 1; i <= n; i++)
		{
			Node node = new Node(i);
			nodes[i] = node;
		}
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			
			int i1 = Integer.parseInt(vals[0]);
			int i2 = Integer.parseInt(vals[1]);
			
			nodes[i1].addNode(nodes[i2]);
			nodes[i2].addNode(nodes[i1]);
			
		}
		
		
		for (int i = 1; i <= n; i++)
		{
			if (bfs(i) == -1)
				return "NO";
		}
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <=n; i++)
		{
			if (nodes[i].table == 1)
			{
				if (sb.length() >0)
					sb.append(' ');
				sb.append(i);
			}
		}
		
		sb.insert(0, "YES\n");
		
		
		
		
		
		return sb.toString();
	}
	
	int bfs(int idx)
	{
		Node srcNode = nodes[idx];
		
		Queue<Node> q = new LinkedList<Node>();
		
		if (srcNode.table != 0)
			return 0;
		
		srcNode.table = 1;
		q.add(srcNode);
		
		while(!q.isEmpty())
		{
			Node node = q.poll();
			
			
			Set<Integer> keys = node.neighbors.keySet();
			for (Integer key : keys)
			{
				//System.out.println("here");
				Node newNode = node.neighbors.get(key);
				
				if (newNode.table == node.table)
					return -1;
				
				if (newNode.table == 0)
				{
					newNode.table = node.table == 1 ? 2 : 1;
				
					q.add(newNode);
				}
			}
		}
		
		return 0;
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();

		System.out.println(sol.calc());

	}

}
