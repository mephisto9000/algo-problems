import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
	
	final int V = 6;
	
	public boolean bfs (int[][] rGraph, int s, int t, int[] parent)
	{
		boolean visited[] = new boolean[V];		
		Arrays.fill(visited, false);
		
		
		Queue <Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		visited[s] = true;
		
		parent[s] = -1;
		
		while(!q.isEmpty())
		{
			int u = q.remove();
			
			for (int v = 0; v < V; v++)
			{
				if (visited[v] == false && rGraph[u][v] > 0)
				{
					q.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}
		
		return (visited[t] == true);
		 
	}
	
	void dfs(int rGraph[][], int s, boolean visited[])
	{
		visited[s] = true;
		for (int i = 0; i < V; i++)
			if (rGraph[s][i]> 0 && !visited[i])
				dfs(rGraph, i, visited);
	}
	
	
	void minCut(int graph [][], int s, int t)
	{
		
		int u, v;
		
		int rGraph[][] = new int[V][V];
		
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				rGraph[i][j] = graph[i][j];
		
		int parent[] = new int[V];
		
		while (bfs(rGraph, s , t , parent))
		{
			int path_flow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v])
			{
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}
			
			//System.out.println("path == "+path_flow);
			
			
			for (v = t; v != s; v = parent[v])
			{
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}
		}
		
		boolean visited[] = new boolean[V];
		
		Arrays.fill(visited,  false);
		dfs(rGraph, s, visited);
		
		
		
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				if (visited[i] & !visited[j] && graph[i][j]> 0)
					System.out.println(i + " - " +j);

					

		
		int sum = 0;
		for (int i = 0; i < V; i++)
			if (rGraph[t][i] > 0) 
				sum += rGraph[t][i];
		
		System.out.println(sum);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int graph[][] = { {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
          };
		
		FordFulkerson fs = new FordFulkerson();
		
		fs.minCut(graph, 0, 5);
		
		
		

	}

}
