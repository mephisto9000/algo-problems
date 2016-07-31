import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution1 {

	/**
	 * @param args
	 */
	
	int cityNum;
	int machineNum;
	int[] machineCities;
	int[][] weightMatrix;
	ArrayList<Integer>[] edgeMatrix;
	int ans = 0;
	
	public class Edge
	{
		public int city1;
		public int city2;
		public int weight;
		
		public Edge(int city1, int city2)
		{
			super();
			this.city1 = city1;
			this.city2 = city2;
			
		}
		
		public int getWeight()
		{
			return weightMatrix[city1][city2];
		}
		
		@Override
		public boolean equals(Object e2)
		{
			int city3 = ((Edge) e2).city1;
			int city4 = ((Edge) e2).city2;
			
			if (((city1 == city3) && (city2 == city4)) ||
				((city2 == city3) && (city1 == city4)))
				return true;
			else
				return false;
		}
	}
	
	public Solution1()
	{
		cityNum = 0;
		machineNum = 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution1 sol = new Solution1();
		sol.prepare();
		sol.calc();

	}
	
	
	public void calc()
	{
		
		ArrayList<Edge> al = new ArrayList<Edge>();
		
		//PriorityQueue pq = new Priorit
		
		
		Comparator c = new Comparator()
		{

			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				//return 0;
				
				Edge e0 = (Edge) arg0;
				Edge e1 = (Edge) arg1;
				
				if (e0.getWeight() <= e1.getWeight())
					return -1;
				else 
					return 1;					
			}			
		};
		
		PriorityQueue pq = new PriorityQueue(cityNum*cityNum, c);
		
		 ans = 0;
				
		for (int i = 0; i < cityNum-1; i++)
		{
			pq.clear();
			
			if (machineCities[i] == 1)
			dfs1(i, -1,  pq);
			//TODO: get the stack from dfs and do smth
			
			
		}
		
		System.out.println(ans);
		
		//pq.c
		
	}
	
	public int dfs2(int city, int parentCity,   PriorityQueue<Edge> stack)
	{
		//dfs2()
		for (int i = 0; i < edgeMatrix[city].size(); i++)
		{
			 int nextCity = edgeMatrix[city].get(i);
		}
		
		return 0;
	
	}
	
	public int dfs1(int city, int parentCity,   PriorityQueue<Edge> stack)
	{

		if (machineCities[city]!=1 && parentCity == -1)
			return -1;

		

		if (parentCity  >= 0)
		{
			Edge edge = new Edge(parentCity, city);
			stack.add(edge);
		}
		
		//System.out.println(":"+city);

		if (machineCities[city] == 1 && parentCity >= 0)
			return 1;
		
		int selfAns = -1;

		for (int i = 0; i < edgeMatrix[city].size(); i++)
		{
		     int nextCity = edgeMatrix[city].get(i);
		     
		     int childAns = 0;

		     if (weightMatrix[city][nextCity] > 0 && nextCity != parentCity)
		    	 childAns = dfs1(nextCity, city, stack);
		     
		     if (childAns == 1)
		    	 selfAns = 1;
		     
		     if (parentCity == -1)
		     {
		    	 if (stack.size()>0)
					{
					Edge e = (Edge) stack.poll();
					
					//System.out.println("edge += "+e.getWeight()+" city1 = "+e.city1+" city2 = "+e.city2);
					
					ans += e.getWeight();
					
					weightMatrix[e.city1][e.city2] = 0;
					weightMatrix[e.city2][e.city1] = 0;
					}
		     }

		}
		
		if (selfAns == 1)
			return 1;
		else
		{
			Edge e = new Edge(parentCity, city);
			stack.remove(e);
			
			return -1;
		}
		
		/*
		for (int i = 0; i < cityNum; i++)
		{
			if (i!= city && weightMatrix[city][i]>0)
			{
				if (!stack.contains(i))
				{
				int  bfsVal = dfs1(i, stack);
				
				if (bfsVal < minDistance)
					minDistance = bfsVal;
				}
			}
		}*/

		//stack.remove((Object) new Integer(city));

		//return minDistance + 1;
	}
	
	
	public void prepare() throws IOException
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		
		String s = br.readLine();
		
		String[] vals = s.split(" ");
		
		
		
		cityNum = Integer.parseInt(vals[0]);
		machineNum = Integer.parseInt(vals[1]);
		
		machineCities = new int[cityNum];
		
		weightMatrix = new int[cityNum][];
		edgeMatrix = new ArrayList [cityNum];
		
		for (int i = 0; i < cityNum; i++)
		{
			weightMatrix[i] = new int[cityNum];
			
			edgeMatrix[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < cityNum-1; i++)
		{
			vals = br.readLine().split(" ");
			int c1 = Integer.parseInt(vals[0]);
			int c2 = Integer.parseInt(vals[1]);
			
			edgeMatrix[c1].add(c2);
			edgeMatrix[c2].add(c1);
			
			int v = Integer.parseInt(vals[2]);
			weightMatrix[c1][c2] = v;
			weightMatrix[c2][c1] = v;
		}
		
		for (int i = 0; i < machineNum; i++)
		{
			int v = Integer.parseInt(br.readLine());
			machineCities[v] = 1;
		}
		
		//topSortInit();
	}

}

