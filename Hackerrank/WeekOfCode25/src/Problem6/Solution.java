package Problem6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	String src = null;
	
	int n;
	int m;
	int q;
	
	Node[] nodes;
	
	class Node
	{
		int nodeId;
		
		List<Node> children;
		
		int value;
		
		public Node(int nodeId)
		{
			children = new LinkedList<Node>();
			value = 0;
			this.nodeId = nodeId; 
		}
		
		public void addChild(Node child)
		{
			children.add(child);
		}
		
		public void setValIfBigger(int newVal, int compareTo)
		{
			if (value > compareTo)
				value = newVal;
		}
	}
	
	public List<Integer> calc() throws Exception
	{
		List<Integer> ans = null;
		
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String[] vals = br.readLine().split(" ");
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		q = Integer.parseInt(vals[2]);
		
		ans = new LinkedList<Integer>();
		
		nodes = new Node[n];
		for (int i = 0; i < n; i++)
			nodes[i] = new Node(i+1);
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			
			int i1 = Integer.parseInt(vals[0]);
			int i2 = Integer.parseInt(vals[1]);
			
			nodes[i1-1].addChild(nodes[i2-1]);
		}
		
		for (int i = 0; i < q; i++)
		{
			vals = br.readLine().split(" ");
			
			int v1 = Integer.parseInt(vals[0]);
			int v2 = Integer.parseInt(vals[1]);
			switch (v1)
			{
			case 1: 
					Node node = nodes[v2-1];
					int v3 = Integer.parseInt(vals[2]);
					bfs(node, v3, -1);
					break;
			case 2: Node node1 = nodes[v2-1];
					int v4 = Integer.parseInt(vals[2]);
					bfs(node1, v4, v4);
					break;
			case 3: 	
				
				ans.add(nodes[v2-1].value);
				break;
				
			}
									
		}
		
		return ans;
	}
	
	public void bfs(Node node, int x, int compar)
	{
		Queue<Node> q = new LinkedList<Node>();
		
		node.setValIfBigger(x, compar);
		q.add(node);
		
		while(!q.isEmpty())
		{
			Node ntmp = q.poll();
			
			for (Node t: ntmp.children)
			{
				t.setValIfBigger(x, compar);
				q.add(t);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		//System.out.println(sol.calc());
		Queue<Integer> ans = (Queue<Integer>) sol.calc();
		//for (int i = 0; i < ans.size(); i++)
		while(!ans.isEmpty())
			System.out.println(ans.poll());

	}

}
