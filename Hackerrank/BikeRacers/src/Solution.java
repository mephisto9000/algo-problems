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
import java.util.Set;

public class Solution {
	
	int n; // bikers
	int m; // bikes
	int k; // bikes participating
	
	int[][] bikerPos;
	int[][] bikePos;
	
	long[][] dist;  //bikers // bikes

	Node[] bikerNodes;
	Node[] bikeNodes;

	List<Node> nodeList;

	private String fname;

	int V;

	Node s; // source
	Node sink;

	//here we'll keep the ordered time;

	long timeArray[];
	long timeAnsArray[];
	int flowArray[];
	int parent[];
	
	
	long minTime = Long.MAX_VALUE;
	
	
	/*
	public class Result{
		
		int score;
		int bikes;
		public Result(int score, int bikes)
		{
			this.score = score;
			this.bikes = bikes;
		}
	}
	*/
	
	public class Node{
		int id;
		List<Edge> edges;
		
		public Node(int id)
		{
			this.id = id;
			edges = new LinkedList<Edge>();
			
		}
		
		public void setId(int id)
		{
			this.id = id;
		}
		
		public void addEdge(Edge e)
		{
			edges.add(e);
		}
		
		public void clearEdges()
		{
			edges = new LinkedList<Edge>();
		}
		
	}
	
	
	public class Edge
	{
		Node from;
		Node to;
		int capacity = 0;
		int flow = 0;
		
		boolean isResidual;
		
		Edge(Node from, Node to, int capacity, boolean isResidual)
		{
			this.from = from;
			this.to= to;
			this.capacity = capacity;
			
			from.addEdge(this);
		}
		
		public int getRemainCapacity()
		{
			return capacity - flow;
		}
		
		public void addFlow(int val)
		{
			flow += val;
		}
		
		public void modifyCapacity(int val)
		{
			this.capacity += val;
		}
	}
	
	
	
	public boolean dfs(Node src, Node sink,   int[] parent)
	{
		if (src == sink)
			return true;
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(src);
		
		boolean visited[] = new boolean[V];
		
		Arrays.fill(visited,  false);
		
		visited[src.id] = true;
		
		while(q.isEmpty() == false)
		{
			Node tmp = q.poll();
			
			for (int i = 0; i < tmp.edges.size(); i++)
			{
				Edge e = tmp.edges.get(i);
				Node to = e.to;
				if (e.getRemainCapacity() > 0 && visited[to.id]==false)
				{
					visited[to.id] = true;
					q.add(to);
					
					parent[to.id] = tmp.id;
					
					if (sink  == to )
						return true;					
				}
			}
			
		}
		
		return false;

	}
	
	
	/*
	 *  belman-fordesque implementation of max flow algorithm
	 */
	public long calcBikeNum()
	{
		int graphHeight = n > m ? n : m;
		
		
		
		int nodeCounter = 0;
		
		//public Node(int id)
		//Edge(Node from, Node to, int capacity, boolean isResidual)
		s = new Node(nodeCounter);
		nodeCounter++;
		sink = new Node(1000000);
		
		nodeList = new ArrayList<Node>();
		nodeList.add(s);
		
		bikerNodes = new Node[n];
		bikeNodes = new Node[m];
		
		for (int i = 0; i < n; i++)
		{
			Node b = new Node(nodeCounter);
			nodeCounter++;
			nodeList.add(b);
			
			
			Edge e = new Edge(s, b, 1, false);
			Edge _e = new Edge(b, s, 1, true);
			
			bikerNodes[i] = b;			
		}
		
		for (int i = 0; i < m; i++)
		{
			Node bb = new Node(nodeCounter);
			nodeList.add(bb);
			nodeCounter++;
			
			
			
			bikeNodes[i] = bb;
		}
		
		sink.setId(nodeCounter);
		nodeCounter++;
		nodeList.add(sink);
		
		int maxTime = 0;
		@SuppressWarnings("unchecked")
		Queue<Long> timeQueue = new PriorityQueue();
		
		/*
		new Comparator<Long>() {
			@Override
		    public int compare(Long n1, Long n2) {
		        // compare n1 and n2
		    	if (n1 < n2)
		    		return 1;
		    	
		    	if (n1 > n2)
		    		return -1;
		    	
		    	return 0;
		    }
		}); */
		
		
		for (int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				//if (dist[i+1][j+1] > maxTime)
				{
					//maxTime = dist[i+1][j+1]
					if (!timeQueue.contains(dist[i+1][j+1]))
					{
						timeQueue.add(dist[i+1][j+1]);
						
						//dist[i+1][j+1]
					}
				}
		
		
		
	
		
		parent = new int[nodeCounter];
		Arrays.fill(parent, -1);
		
		V = nodeCounter;
		long time ;
		
		timeArray = new long[timeQueue.size()];
		timeAnsArray = new long[timeQueue.size()];
		flowArray = new int[timeQueue.size()];
		
		
		Arrays.fill(timeAnsArray, -1);
		Arrays.fill(flowArray, 0);
		
		int timeIdMax = 0;
		for (int i = 0 ; i< timeQueue.size(); i++)
		{
			timeArray[i] = timeQueue.poll();
			
			System.out.println(timeArray[i]);
			timeIdMax = i;
		}
		
		long minTime = Long.MAX_VALUE;
		
		int timeIdMin = 0;
		//int timeIdMax = timeArray.length - 1;
		//int timeId = 0;
		
		
		 //System.out.println(timeIdMax+"dddd"+timeArray[timeIdMax]);
		
		return bikeSearchBinary(0,  timeArray[timeIdMax] );
 		 
	}
	
	
	long bikeSearchBinary(long minTime, long maxTime)
	{
		
		//System.out.println(minTime + "   " + maxTime);
		long low = minTime;
		long high = maxTime;
		long   mid = minTime;

		while(low < high)
		{
			mid = (low + high) / 2;
			
			if( bikeSearch( mid ) )
			{
				high = mid;
			}
			else
			{
				low = mid+1 ;
			}

		}
		
		return high; //  + 1;
	}
	
	//long
	
	boolean bikeSearch(long time) //int timeIdMin, int timeIdMax)
	{
		// we first clean our network of useless (now) edges
		 //time = timeQueue.poll(); 
		 //System.out.println("time == "+time);
		 
		//int timeId = (timeIdMax + timeIdMin) / 2;
		
		//System.out.println("tid == "+timeId+" timeIdMin == "+timeIdMin + " timeIdMax == "+timeIdMax);
		//long time = timeArray[timeId];
		 
		 s.clearEdges();
		
		for (int i = 0; i < n; i++)
		{
			bikerNodes[i].clearEdges();
			
			Edge e = new Edge(s, bikerNodes[i], 1, false);
			Edge _e = new Edge(bikerNodes[i], s, 1, true);
		}
		
		
		for (int i = 0; i < m; i++)
		{
			bikeNodes[i].clearEdges();
			
			Edge e = new Edge(bikeNodes[i], sink, 1, false);
			Edge _e = new Edge(sink, bikeNodes[i], 1 , true);
		}
		
		
		
		// here we rebuild our network
		
		for (int i = 0; i < n; i++)
		{
			for (int j =0; j < m; j++)
			{
				if (dist[i+1][j+1] <= time)
				{
					Edge e = new Edge(bikerNodes[i], bikeNodes[j], 1, false);
					Edge e1 = new Edge( bikeNodes[j], bikerNodes[i], 1, true);
				}
			}
		}
		
		
		int flow = 0 ;//Integer.MAX_VALUE;
		
		while(dfs(s, sink, parent))
		{
			
			//System.out.println("i'm here");
			
			Node t = sink;
			int minCapacity = Integer.MAX_VALUE;
			
			//calculating minimal capacity
			while(parent[t.id] != -1)
			{
				Node t1 = nodeList.get(parent[t.id]);
				for (int j = 0; j< t1.edges.size(); j++)
				{
					Edge e = t1.edges.get(j);
					if (e.to.id == t.id )
					{
						if (minCapacity > e.getRemainCapacity() )
						{
							minCapacity = e.getRemainCapacity();
							break;
						}
					}
						
					
				}
				
				 
				t = nodeList.get(parent[t.id]);
			}
			
		   flow += minCapacity;
			
			t = sink;
			while(parent[t.id] != -1)
			{
				
				Node t1 = nodeList.get(parent[t.id]);
				
				
				for (int j = 0; j < t1.edges.size(); j++)
				{
					Edge e = t1.edges.get(j);
					if (e.to.id == t.id)
					{
						e.addFlow(minCapacity);
						Node to = e.to;
						
						for (int k = 0; k < to.edges.size(); k++)
						{
							Edge _e = to.edges.get(k);
							
							if (_e.to.id == t1.id)
							{
								_e.addFlow(-minCapacity);
							}
							
						}
						
						break;
 						
					}
					
				}
				
				t = nodeList.get(parent[t.id]);
			}
 			
		}
		
		//System.out.println("flow == " + flow+" k == "+k);
		
		//flowArray[timeId] = flow;
		
		 if (flow >= k)
			 return true;
		 else
			 return false;
		
	 
		
		
	
	}


	public long  calc() throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br;
		
		if (fname == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(fname));
		
		String[] vals = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		m = Integer.parseInt(vals[1]);
		k = Integer.parseInt(vals[2]);
		
		bikerPos = new int[n][2];
		bikePos = new int[m][2];
		
		dist = new long[n+1][m+1];
		
		for (int i = 0; i < n; i++)
		{
			vals = br.readLine().split(" ");
			bikerPos[i][0] = Integer.parseInt(vals[0]);
			bikerPos[i][1] = Integer.parseInt(vals[1]);
		}
		
		for (int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			bikePos[i][0] = Integer.parseInt(vals[0]);
			bikePos[i][1] = Integer.parseInt(vals[1]);
		}
		
		for (int i = 0; i <= n; i++)
		{
 			Arrays.fill(dist[i], 0);
		}
		
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m;j ++)
			{
				int d =    (int) ( Math.pow((bikePos[j][0] - bikerPos[i][0]),2) + Math.pow(bikePos[j][1] - bikerPos[i][1], 2));
				
				dist[i+1][j+1] = d;
				

   
			}
		}
		
		 
		return calcBikeNum();
		
		
		
	}
	
	 
	
	public void setFilename(String fname)
	{
		this.fname = fname;
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		if (args.length > 0)
			sol.setFilename(args[0]);
		
		System.out.println((int) sol.calc());

	}

}

