import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public class Node{
		public int i;
		public int j;
		public boolean isDest = false;
		List<Node> neighbours;
		public boolean isVisited = false;
		public int step = 0;
		
		public String getKey()
		{
			return new String(i+"_"+j);
		}
		
		public Node(int i, int j, boolean isDest)
		{
			super();
			this.i = i;
			this.j = j;
			this.isDest = isDest;
			this.neighbours = new LinkedList<Node>();
		}
		
		
		
		public void addEdge(Node n)
		{
			if (!neighbours.contains(n))
					neighbours.add(n);
		}
	}
	
	public Map<String, Node> paths;
	//public List<Node> nodes;
	
	public int dirToX(char dir)
	{
		switch(dir)
		{
			case 'N':
				return 0;				
			case 'S':
				return 0;
			case 'W':
				return -1;
			case 'E':
				return 1;
				
		}
		return 0;
	}
	
	public int dirToY(char dir)
	{
		switch(dir)
		{
		case 'N':
			return 1;
		case 'S':
			return -1;
		case 'W':
			return 0;
		case 'E':
			return 0;
		}
		
		return 0;
	}
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input4.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		//nodes = new LinkedList<Node>();
		paths = new HashMap<String, Node>(); 
		
		
		//nodes.add(start);
		
		for (int i = 0; i < n; i++)
		{
			
			/*
			for (Node nnn : nodes )
			{
				System.out.println("removing "+nnn.getKey());
				nnn.isVisited = false;
				nnn.isDest = false;
				nnn.step = 0;
				
				//paths.put(nnn.getKey(), nnn);
			} */
			
			br.readLine();
			
			int p = Integer.parseInt(br.readLine()); //num of steps in path;
			
			
			//Node start = null;
			//Node source = null;
			Node last = null;
			int x = 0;
			int y = 0;
			
			Node start = new Node(0,0, false);
			last = start;
			
			paths = new HashMap<String, Node>();
			paths.put(start.getKey(), start);
			
			for (int j = 0; j < p; j++)
			{
				char dir = br.readLine().charAt(0);
				
				x+= dirToX(dir);
				y+= dirToY(dir);
				
				Node mid = null;
				
				
				
				String midKey = x+"_"+y;
				//if (paths.get(midKey)
				mid = paths.get(midKey);
				if (mid == null)
				{
					mid = new Node(x,y,false);
					//nodes.add(mid);
					paths.put(mid.getKey(), mid);
				}
				
				if (j == (p-1))
				{
					//mid = new Node(x,y,true);
					mid.isDest = true;
					
					//System.out.println("dest is "+mid.getKey());
					//mid.isDest = true;
				}
				//else
				//	mid = new Node(x,y,false);
				
				//System.out.println("key == "+mid.getKey());
				
				
				/*
				Node oldMid = paths.get(mid.getKey());
				if (oldMid != null)
				{
					atBay.addEdge(mid);
					mid.addEdge(atBay);
				} */
				
				
				
				
				//last.setNext(mid);
				last.addEdge(mid);
				mid.addEdge(last);
				last = mid;
				
				 
			}
			
			//int pnum = 0;
			Node tmp = paths.get(start.getKey());
			Queue<Node> stack = new LinkedList();
			//stack.

			stack.add(start);
			start.isVisited = true;
			while(stack.size() > 0)
			{
				tmp = stack.poll();
				
				//System.out.println(tmp.getKey() + " step == "+tmp.step);
				
				
				if (tmp.isDest == true)
				{
					System.out.println(tmp.step);
					break;
				}
				
				for (int j = 0; j < tmp.neighbours.size(); j++)
				{
					Node neighbour = tmp.neighbours.get(j);
					if (neighbour.isVisited == false)
					{
						neighbour.isVisited = true;
						neighbour.step = tmp.step + 1;
						stack.add(neighbour);
						
					}
					
				}
				 
				
				
				//tmp = paths.get(tmp.nextKey);
				//pnum++;
			}
			
			
			
		}
	}
	
	public static void main(String[] args) throws Exception
	{		
		Solution sol = new Solution();	
		sol.calc();
				
	}

}
