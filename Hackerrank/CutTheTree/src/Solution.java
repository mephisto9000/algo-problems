import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution {
	
	
	int minDiff = Integer.MAX_VALUE;
	int sumWeights = 0;
	int [] weights;
	
	
	Node[] nodes;
	boolean[] visited;
	int[] sumArray;
	
	public class Node{
		int idx;
		int weight;
		int cutWeight;
		
		List<Integer> neighbours;
		
		public Node(int idx, int weight)
		{
			this.idx = idx;
			this.weight = weight;
			
			neighbours = new LinkedList<Integer>();
		}
		
		public void addNeighbour(int neighbourIdx)
		{
			neighbours.add(neighbourIdx);
		}
		
		
	}
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		int n = Integer.parseInt(br.readLine());
		
		String[] vals = br.readLine().split(" ");
		
		weights = new int[n];
		nodes = new Node[n];
		
		visited = new boolean[n];
		sumArray = new int[n];
		
		Arrays.fill(visited, false);
		Arrays.fill(sumArray, 0);
		
		
		
		for (int i = 0; i < n; i++)
		{
			weights[i] = Integer.parseInt(vals[i]);
			sumWeights += weights[i];
			Node node = new Node(i, weights[i]);
			nodes[i] = node;
		}
		
		for (int i = 0; i< n-1; i++)
		{
			vals = br.readLine().split(" ");
			int idx1 = Integer.parseInt(vals[0]) - 1;
			int idx2 = Integer.parseInt(vals[1]) - 1;
			
			Node x = nodes[idx1];
			x.addNeighbour(idx2);
			
			x = nodes[idx2 ];
			x.addNeighbour(idx1);
		}
		
		dfsI();
		
		System.out.println(minDiff);
		
		
		
		
	}
	
	
	public void dfsI()
	{
		
		Node x = nodes[0];
		
		Stack<Node> stack = new Stack<Node>();
		visited[0] = true;
		
		stack.push(x);
		
		Stack<Node> topSort = new Stack<Node>();
		
		while(!stack.isEmpty())
		{
			x = stack.pop();
			int sum = 0;
			
			//System.out.println(x.idx);
			
			for (int i : x.neighbours)
			{
				if (!visited[i])
				{
					visited[i] = true;
					Node z = nodes[i];
					stack.push(z);
				}
			}
			
			topSort.push(x);
		}
		
		int sum = 0;
		Arrays.fill(visited, false);
		
		while(!topSort.isEmpty())
		{
			
			x = topSort.pop();
			visited[x.idx] = true;
			
			x.cutWeight = x.weight;
			//sum += x.weight;
			
			for (int i : x.neighbours)
			{
				if (visited[i])
				{
					
					Node z = nodes[i];
					
					x.cutWeight += z.cutWeight;
				}
			}
			
			
			
			if (Math.abs((sumWeights - x.cutWeight ) - x.cutWeight)  < minDiff)
			{
				
				
				minDiff = Math.abs((sumWeights - x.cutWeight ) - x.cutWeight); // sumWeights - sum  ;
				
				
			}
			
			
		}
	}
	
	 

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		
		
		sol.calc();

	}

}
