import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
	
	int n; // bikers
	int m; // bikes
	int k; // bikes participating
	
	int[][] bikerPos;
	int[][] bikePos;
	double[][] dist;  //bikers // bikes
	private String fname;
	
	
	public class Result{
		
		int score;
		int bikes;
		public Result(int score, int bikes)
		{
			this.score = score;
			this.bikes = bikes;
		}
	}
	
	public Double  calc() throws Exception
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
		
		dist = new double[n+1][m+1];
		
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
			//vals = br.readLine().split(" ");
			//bikerPos[i][0] = Integer.parseInt(vals[0]);
			//bikerPos[i][1] = Integer.parseInt(vals[1]);
			Arrays.fill(dist[i], 0);
		}
		
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m;j ++)
			{
				double d =    ( Math.pow((bikePos[j][0] - bikerPos[i][0]),2) + Math.pow(bikePos[j][1] - bikerPos[i][1], 2));
				
				dist[i+1][j+1] = d;
				
				System.out.println(d);
			}
		}
		
		/*
		Set cycles = new HashSet();
		
		int ans = (int) minSumDist(0, cycles);
		System.out.println(ans  );
		*/
		return kuhn();
		
		
		
	}
	
	public double kuhn()
	{
		//List<Integer> p = new LinkedList<Integer>();
		//List<Integer> way = new LinkedList<Integer>();
		//List<Integer> u = new LinkedList<Integer>();
		//List<Integer> v = new LinkedList<Integer>();
		int u[] = new int[n+1];
		Arrays.fill(u,  0);
		
		int v[] = new int[m+1];
		Arrays.fill(v, 0);
		
		
		int p[] = new int[m+1];
		Arrays.fill(p, 0);
		int way[] = new int [m+1];
		
		for (int i = 1; i <= n; i++)
		{
			p[0] = i;
			
			int j0 = 0;
			
			double minv[] = new double[m+1];
			Arrays.fill(minv, Double.MAX_VALUE);
			
			boolean used[]= new boolean[m+1];
			Arrays.fill(used, false);
			
			
			do
			{
				used[j0] = true;
				
				int i0 = p[j0];
				double delta = Double.MAX_VALUE;
				
				int j1 = 0;//Integer.MAX_VALUE; 
				
				for (int j = 1; j <= m; j++)
				{
					if (!used[j]) 
					{
						double cur = dist[i0][j] - u[i0] -v[j];
						
						if (cur < minv[j])
						{
							minv[j] = cur;
							way[j] = j0;
						}
						
						if (minv[j] < delta)
						{
							delta = minv[j];
							j1 = j;
						}
						
						
						
					}
				}
				
				
				for (int j = 0; j <=m; j++)
				{
					if (used[j])
					{
						u[p[j]] += delta;
						v[j] -= delta;
					}
					else
						minv[j] -= delta;
				}
				
				j0 = j1;
			}while(p[j0]!= 0);

			do
			{
				int j1 = way[j0];
				
				p[j0] = p[j1];
				j0 = j1;
				
			}
			while (j0>0);
			
			
		}
		
		
		int[] ans = new int [n+1];
		
		Arrays.fill(ans, 0);
		
		for (int j=1; j<=m; ++j)
			{
			ans[p[j]] = j;
			
			
			
			}
		
		double max = 0;
		
		Queue q = new PriorityQueue();
		
		
		
		for (int j=1; j<=m; ++j)
			//if (dist[j-1][ans[j]-1] > max) // != j)
				q.add(dist[j][ans[j]]);
		
		for (int i = 0;  i < k; i++)
		{
			max = (Double) q.poll();
			System.out.println(max);
		}
			//System.out.println(q.poll());
			
		//while.

		

		System.out.println((int) max);
		
		
		
		
		return max;
	}
	
	public double minSumDist(int cyclerId, Set cycles)
	{
		
		
		if (cyclerId >=  k ) 						
				//return new Result(0, cycles.size()); //Float.MAX_VALUE;
			//return 0;
			return Float.MAX_VALUE;
		
		
		if (cyclerId == n-1 && cycles.size() < k-1)
			return Float.MAX_VALUE;
		
		//if (cyclerId cycles.size() < k)
		//	//return new Result(Float.MAX_VALUE-1, cycles.size());;
			
			
		
		//if (cyclerId >=  n
		
		double min = Float.MAX_VALUE;
		
		for (int i = 0; i < m; i++)
		{
			if (!cycles.contains(i))
			{
				
				//System.out.println(cyclerId+" "+i);
				double d = dist[cyclerId][i];
				
				cycles.add(i);
				double v = 0;
				
				
				
				if (cyclerId + 1 < n && cycles.size() < k ) 
					v = minSumDist(cyclerId+1, cycles);
				
				
				double tmpMin = d > v ? d : v;
				
				if (tmpMin == Float.MAX_VALUE)
					continue;
				
				/*
				System.out.println(cycles.toString());
				
				if (cyclerId == 0)
				{
				System.out.println("cyclerId == " + cyclerId);
				System.out.println("tmpMin == "+ tmpMin);
				System.out.println("d == "+ d);
				System.out.println("v == "+ v);
				}
				*/
				
				if (tmpMin < min)
					min = tmpMin;
				
				cycles.remove(i);
				
				
			}
		}

		
		double v = Integer.MAX_VALUE;

		if (cyclerId + 1 < n) 
		v = minSumDist(cyclerId+1, cycles);
		
		/*
		if (cyclerId == 0)
		{
			System.out.println("not selected " +v);
		} */
		
		if (v < min && v != Float.MAX_VALUE)
			min = v;
		
		
		//System.out.println(min);
		return min;
		
	}
	
	public void setFilename(String fname)
	{
		this.fname = fname;
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		if (args.length > 0)
			sol.setFilename(args[0]);
		
		System.out.println((int) sol.calc().doubleValue());

	}

}
