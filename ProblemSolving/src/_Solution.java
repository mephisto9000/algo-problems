import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class _Solution {
	
	Node[] nodes;
	
	
	public class Node{
		Node parent;
		List<Node> children;
		int difficulty;
		int vi;
		
		public Node(int difficulty, int vi)
		{
			children = new LinkedList<Node>();
			this.difficulty = difficulty;
			this.vi = vi;
			parent = null;
			
			
		}
		
		public void addChild(Node n)
		{
			children.add(n);
		}
		
		public void setParent(Node n)
		{
			parent = n;
		}
	}

	
	public void calc() throws Throwable	
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++)
		{
			String vals[] = br.readLine().split(" ");
			
			int n = Integer.parseInt(vals[0]);
			int k = Integer.parseInt(vals[1]);
			
			nodes = new Node[n];
			
			vals = br.readLine().split(" ");
			
			for (int j = 0; j < n; j++)
			{
				//here goes the magic
				
				Node x = new Node(j, Integer.parseInt(vals[j]));
				
				nodes[j] = x;
			}
			
			
			for (int j = 0; j < n; j++)
			{
				Node x = nodes[j];
				
				for (int z = j+1; z < n; z++)
				{
					Node x1 = nodes[k];
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Throwable{
		
		_Solution sol = new _Solution();
		sol.calc();
		

	}

}
