import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Solution {

	
	long[] dvals; 
	
	List<Set<Long>> components;
	
	int[] mst;
	
	public void initTree()
	{
		mst = new int[65];
		//Arrays.fill(mst,
		for (int i = 0; i <= 64; i++)
		{
			mst[i] = i;
		}
	}
	
	public int findParent(int i)
	{
		if (mst[i] == i)
			return i;
		else return (findParent(i));
	}
	
	public void union(int i, int j)
	{
		int pi = findParent(i);
		int pj = findParent(j);
		
		mst[pj] = pi; 
		
		
	}
	
	public int calcComponents()
	{
		int res = 64;
		for (int i = 1; i <= 64; i++)
		{
			if (mst[i]!= i)
				res --;
		}
		
		return res;
	}
	
	public void calc()
	{
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int n = Integer.parseInt(br.readLine());
			
			String[] vals = br.readLine().split(" ");
			
			dvals = new long[n];
			
			for (int i = 0; i < n; i++)
			{
				dvals[i] = Long.parseLong(vals[i]);
								
			}
			
			//components = new ArrayList<Set<Long>>();
			
			//int z = 1;
			int perms = (int) Math.pow(2, n);
			
			//List<Integer> ans = new ArrayList<Integer>();
			
			int result = 0;
			
			/*
			 * for (int j = 0; j < 64; j++)
				{
					if ((((i+1) >> j) & 1) == 1)
						
				}
			 */
 			for (int i = 0; i< perms; i++)
			{
				List<Long> tempSet = new ArrayList<Long>();
				
				//while()
				for (int j = 0; j < 32; j++)
				{
					if (((i >> j) & 1) == 1)
						tempSet.add(dvals[j]);
				
				}
				
				
				initTree();
				
				for (int j = 0; j < tempSet.size(); j++)
				{
					long val = tempSet.get(j);
					
					int lastZ = -1;
					for (int z = 0; z < 64; z++)
					{
						if (((val >> z) & 1) == 1)
						{
							if (lastZ >= 0)
							{
								union((lastZ+1), z);
								lastZ = z;
							}
							else
							{
								lastZ = z;
							}
						}
							
					}
					
					
					
				}
				int midAns = calcComponents();
				//System.out.println("_"+midAns);
				
				result += midAns;
				
				
												
			}
			
 			System.out.println(result);
			
			
		
		}
		catch(IOException e)
		{
			// hi
		}
		
		
	}
	public static void main(String[] args) {
		
		
		Solution sol = new Solution();
		
		sol.calc();
		
		

	}

}
