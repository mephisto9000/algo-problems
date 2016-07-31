import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	
	int[][] complement ;
	final int maxN = 6250;
	int n;
	int m;

	public void calc() throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input4.txt"));
		
		StringBuffer sb = new StringBuffer();
		
		Map s = null;
		
		
		Map complement = new HashMap();
		
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++)
		{
			
			String[] vals = br.readLine().split(" ");
			
			 n = Integer.parseInt(vals[0]);
			 m = Integer.parseInt(vals[1]);
			
			
			s = new HashMap();
			
			
			
			 
			
			
			for (int j = 0; j < m; j++)
			{
				
			vals = br.readLine().split(" ");
			
			int x = Integer.parseInt(vals[0]);
			int y = Integer.parseInt(vals[1]);
			
			//s.add(x);
			//s.add(y);
			
			
			if (!s.containsKey(x))
				s.put(x, new HashSet());
			HashSet hs = (HashSet) s.get(x);
			hs.add(y);
			
			if (!s.containsKey(y))
				s.put(y, new HashSet());
			
			hs = (HashSet) s.get(y);
			hs.add(x);

			}
			
			
			
			
			int rust = Integer.parseInt(br.readLine());
			
			sb = new StringBuffer();
			
			for (int j  = 0; j < n; j++)
			{
				if (j == rust-1)
					continue;
				
				
				if (s.containsKey(rust))
				{
				HashSet hs = (HashSet) s.get(rust);
				
				if (hs.contains(j+1))
				{
					if (hs.size() < n-1000)
						sb.append(2);
					else					
						sb.append(bfs(rust-1, j, s));
				}
					//System.out.println(2);
				else
					sb.append(1);
					//System.out.println(1);
				}
				else
					sb.append(1);
				sb.append(" ");
			}
			
			System.out.println(sb.toString().trim());
			
		}
		
				
		
	}
	
	public int bfs(int src, int dst, Map graph)
	{
		//int n = graph.length;
		boolean[] used = new boolean[n];
		
		Arrays.fill(used,  false);
		
		Queue<Integer> q = new LinkedList();
		Queue<Integer> distance = new LinkedList();
		
		used[src] = true;
		q.add(src);
		distance.add(0);
		
		int res = 0;
		while (!q.isEmpty())
		{
			int s = q.poll();
			
			//System.out.println("n == "+n +" s == "+s+" dst =="+dst);
			int dist = distance.poll() ;
			
			if (s == dst)
			{
				res = dist;
				break;
			}
			
			HashSet hs = (HashSet) graph.get(s+1);
			
			if (hs == null)
			{		
				/*
				if (graph[s][i] == 1 && !used[i])
				{
					used[i] = true;
					q.add(i);
					distance.add(dist+1);
					
					
				}*/
				for (int i = 0; i < n; i++)
				if (!used[i])
				{
					used[i] = true;
					q.add(i);
					distance.add(dist+1);
				}
			}
			else			
			for (int i = 0; i < n; i++)
			{
				/*
				if (graph[s][i] == 1 && !used[i])
				{
					used[i] = true;
					q.add(i);
					distance.add(dist+1);
					
					
				}*/
				
				if (!hs.contains(i+1) && !used[i])
				{
					used[i] = true;
					q.add(i);
					distance.add(dist+1);
				}
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
