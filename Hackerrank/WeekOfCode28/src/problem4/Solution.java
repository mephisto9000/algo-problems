package problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
	
	
	String src = null;
	
	int[] tree; // kruskall
	BigInteger[] power; // kruskall
	
	BigInteger tmpPower;
	long powerIdx = -1;
	BigInteger  powerIncrement;// = 0;
	BigInteger  powerSum;
	
	boolean testMode = false;
	
	int n;
	int m;
	
	Node[] nodes;
	
	public class Node implements Comparable
	{
		int num;
		long count;
		
		Set<Node> connections;
		
		public Node()
		{
			connections = new HashSet<Node>();
		}
		
		@Override
		public int compareTo(Object o) {
			
			Node n1 = (Node) o;
			
			if (this.count > n1.count)
				return -1;
			if (this.count < n1.count)
				return 1;
			
			return 0;
		}
	}
	
	public class Edge
	{
		int x1;
		int x2;
	}
	
	public void testPrint(String s)
	{
		if (testMode)
			System.out.println(s);
	}
	
	public String[] calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		int q = Integer.parseInt(br.readLine());
		
		String[] ans = new String[q];
		for (int i = 0; i < q; i++)
		{
			
			
			testPrint( " -------- ");
			String vals[] = br.readLine().split(" ");
			
			n = Integer.parseInt(vals[0]);
			m = Integer.parseInt(vals[1]);
			
			tmpPower = BigInteger.ZERO; //0;
			powerSum = BigInteger.ZERO; //0;
			initKruskall();
			
			
			for (int j = 0; j < m; j++)
			{
				vals = br.readLine().split(" ");
				int idx1 = Integer.parseInt(vals[0]) - 1;
				int idx2 = Integer.parseInt(vals[1]) - 1;
				
				nodes[idx1].count ++;
				nodes[idx2].count ++;
				
				nodes[idx1].connections.add(nodes[idx2]);
				nodes[idx2].connections.add(nodes[idx1]);
			}
			
			Queue<Node> queue = new PriorityQueue<Node>();
			
			for (int j = 0; j < n; j++)				
				queue.add(nodes[j]);
			
			
			
			Queue<Edge> reminderQueue = new LinkedList<Edge>();
					
			while(queue.size() > 0)
			{
				Node x = queue.poll();
				
				 
				Iterator<Node> xit = x.connections.iterator();
				while(xit.hasNext()) 
				{
					Node x2 = xit.next();
					
					 
					
					Node removeNode = null;
					int w = 0;
					for (Node x3 : x2.connections) //.size(); z++)
					{
						 
						
						if (x3.num == x.num)
						{
							 
							removeNode = x3;
						}
						w ++;
						
					}
					
					
					if(removeNode != null)
						x2.connections.remove(removeNode); 
					
					
					if (findParent(x.num) == findParent(x2.num))
					{
						Edge e = new Edge();
						e.x1 = x.num;
						e.x2 = x2.num;
						reminderQueue.add(e);
					}
					else 
					merge(x.num, x2.num);
				}
				
				x.connections.clear();
			}


			while(!reminderQueue.isEmpty())
			{
				Edge e = reminderQueue.poll();
				merge(e.x1, e.x2);
			}

			ans[i] = tmpPower.toString();
		}
		
		return ans;
		
		
	}
	
	private void initKruskall()
	{
		tree = new int[n];
		power = new BigInteger[n];
		
		nodes = new Node[n];
		
		for (int i = 0; i < n; i++)
		{
			tree[i] = i;
			nodes[i] = new Node();
			
			nodes[i].num = i;
			nodes[i].count = 0;
			
			
			power[i] = BigInteger.ZERO;
		}	
		
	}
	
	private int findParent(int idx)
	{
		if (tree[idx] == idx)
			return idx;
		else
		{
			int x = findParent(tree[idx]);
			tree[idx] = x;
			
			return x;
		}
	}
	
	private void merge(int x, int y)
	{
		int px = findParent(x);
		
		int py = findParent(y);
		
		testPrint(x + " --- " + y);
		
		
 		BigInteger powerDecrement = BigInteger.ZERO;
		if (px != py)
		{
			//powerDecrement = power[px]*(power[px] + 1) + power[py] * (power[py] + 1);
			
			powerDecrement = power[px].multiply(power[px].add(BigInteger.ONE));
			powerDecrement = powerDecrement.add(power[py].multiply(power[py].add(BigInteger.ONE)));
			
			 double rand = Math.random() * 1;
			    if (Math.round(rand) == 1) {
			    	//power[py] += power[px] + 1;
			    	power[py] = power[py].add(power[px]);
			    	power[py] = power[py].add(BigInteger.ONE);
					power[px] = BigInteger.ZERO;					
					tree[px] = py;
			    } else {
			    	power[px] = power[px].add(power[py]);//+= power[py] + 1;					
					power[px] = power[px].add(BigInteger.ONE);//0;
					tree[py] = px;
			    }
			    			
			//if (power[py] > 0)
			if (power[py].compareTo(BigInteger.ZERO) > 0)
			{				 
				powerIdx = py;
				//powerIncrement = power[py] * ( power[py] + 1);
				powerIncrement = power[py].multiply( power[py].add(BigInteger.ONE));
			}
			else
			{
				powerIdx = px;
				//powerIncrement = power[px] * ( power[px] + 1);
				powerIncrement = power[px].multiply( power[px].add(BigInteger.ONE));
			}
														
		}
		
		else
		{
 			powerIncrement = BigInteger.ZERO;
			powerDecrement = BigInteger.ZERO;
		}
 		
		//powerSum += powerIncrement - powerDecrement;
		powerSum = powerSum.add(powerIncrement.subtract(powerDecrement));
		
		 //tmpPower +=  powerSum;
		tmpPower =  tmpPower.add(powerSum);
		
		
		/*
		for (int i = 0 ; i < power.length; i++)
		{
			//if (i != powerIdx)
				//if ()
				int p = findParent(i);
					tmpPower += power[p];
		} 
		*/
		 
		 
		testPrint("power now == "+tmpPower + " powerInc == "+powerIncrement + " powerIdx == "+powerIdx + " powerDec == "+powerDecrement + " powerSum == "+powerSum);
		
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol  = new Solution();
		
		//System.out.println( sol.calc() );
		String[] arr = sol.calc();
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}

	}

}
