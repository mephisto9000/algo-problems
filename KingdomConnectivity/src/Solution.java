import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	//public long total = 0;
	public boolean stop = false;

	public enum Color
	{
		WHITE, GRAY, BLACK;
	}
	public class Node{
		int idx;
		List<Node> path;
		Color color;
		
		long path_num  = 0L;
		
		public Node(int idx)
		{
			super();
			this.idx = idx;
			color = Color.WHITE;
			path = new LinkedList<Node>();
		}
		
		public void addPath(Node node)
		{
			
			//if (!path.contains(node))
				path.add(node);
		}
		
		
	}
	
	List<Node> country;
	
	public void calc() throws Exception
	{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		String vals[] = br.readLine().split(" ");
		int n = Integer.parseInt(vals[0]);
		int m = Integer.parseInt(vals[1]);
		
		country = new ArrayList<Node>(n);
		
		for(int i = 0; i < n; i++)
		{
			country.add(new Node(i));
		}
		
		for(int i = 0; i < m; i++)
		{
			vals = br.readLine().split(" ");
			int x = Integer.parseInt(vals[0]) -1;
			int y = Integer.parseInt(vals[1]) -1;
			
			Node nodeX = country.get(x);
			Node nodeY = country.get(y);
			
			nodeX.addPath(nodeY);
			
		}
		
		Node src = country.get(0);
		Node dest = country.get(n-1);
		
		
		long result = dfs(src, dest, new HashSet<Node>(), false); //, new HashSet<Node>()
		if (stop)
			System.out.println("INFINITE PATHS");
		else		
			System.out.println((src.path_num  % 1000000000L));
		
	}
	
	public long dfs(Node src, Node dest, Set path, boolean loop_detected)
	{
		
		//System.out.println("src.idx == "+src.idx + " dest.idx == "+dest.idx);
		if (src.idx == dest.idx )
		{
			if ( loop_detected == true)
				stop = true;
			//total ++;
			
			src.path_num = 1L;
			return 1L;
		}
		
		if (path.contains(src))
		{
			/*
			Iterator g = path.iterator();
			{
				while(g.hasNext())
				{
					Node ggg = (Node) g.next();
					System.out.println("node == "+(ggg.idx+1));
				}
			}
			System.out.println((src.idx + 1)); 
			return -1;
			*/
			
			//path.
			
			return -1L;
		}
		
		
		path.add(src);
		//visited.add(src);
		//BigInteger pcount = BigInteger.valueOf(0);
		long pcount = 0L;
		
		
		//System.out.println("src idx == "+ src.idx);
		for (Node node : src.path)
		{
			
			if (stop)
				return -1L;
			
			if (node.path_num  > 0L)
			{
				pcount = ( pcount +node.path_num)  % 1000000000L; // pcount.add(BigInteger.valueOf(node.path_num));//(pcount + node.path_num ) % 1000000000L ;
				continue;
			}
			
			if (node.path_num  < 0L)
			{
				continue;
			}
			
			//System.out.println("src idx == "+ src.idx + " --> "+node.idx);
			//if (!visited.contains(node))
			
			long v = (dfs(node, dest, path, loop_detected));
			
			if (v  ==  -1L )
				loop_detected = true;
			else
				if (v  >= 0L )
					pcount = (pcount + v ) % 1000000000L;
				//pcount.add(BigInteger.valueOf(v));
			
			
		}
		
		path.remove(src);
		
		if (pcount > 0L) 
			src.path_num  =  pcount ; //( pcount % 1000000000L); //( pcount  % 1000000000);
		else
			src.path_num = -2L;
		
		return src.path_num;
	}
	
	public static void main(String[] args) throws Exception{
	
		Solution sol = new Solution();
		sol.calc();

	}

}
