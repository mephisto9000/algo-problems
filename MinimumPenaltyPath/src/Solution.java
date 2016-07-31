import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	Node[] nodes;
	
	public class Node {
		
		public int node_num;
		public boolean visited = false;
		public List<Integer> connections;
		public List<Integer> prices;
		
		
		
		public Node(int node_num)
		{
			this.node_num = node_num;
			connections = new LinkedList<Integer>();
			prices = new LinkedList<Integer>();
		}
		
		public void addIfNotExists(int new_node, int price)
		{
			if (!connections.contains(new_node))
			{
				connections.add(new_node);
				prices.add(price);
			}
		}
	}
	
	
	public void calc() throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int m = Integer.parseInt(vals[1]);
		
		nodes = new Node[n];
		
		for (int i = 0; i < n; i++)
		{
			nodes[i] = new Node(i);
		}
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			
			int u = Integer.parseInt(vals[0]);
			int v = Integer.parseInt(vals[1]);
			
			int c = Integer.parseInt(vals[2]);
			
			nodes[u].addIfNotExists(v, c);
			nodes[v].addIfNotExists(u, c);
			
		}
		
		
	}

	public static void main(String[] args) throws Exception{


		Solution sol = new Solution();
		
		sol.calc();

	}

}
