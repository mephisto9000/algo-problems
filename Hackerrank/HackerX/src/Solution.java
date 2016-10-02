import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	
	public String src = null;
	
	
	class Pair
	{
		int v1;
		int v2;
		
		public  Pair(int v1, int v2)
		{
			this.v1 = v1;
			this.v2 = v2;
		}
			
		int compareFirst(Pair p)
		{
			if (v1 == p.v1)
				return 0;
			else return (v1 < p.v1 ? -1: 1);
		}
		
		int compareSecond(Pair p)
		{
			if (v2 == p.v2)
				return 0;
			else return (v2 < p.v2? -1: 1);
		}
		
	}
	
	public class PairComparator implements Comparator<Pair>
	{

		@Override
		public int compare(Pair o1, Pair o2) {
			// TODO Auto-generated method stub
			
			int firstResult = o1.compareFirst(o2);
			 if (firstResult == 0) { //First comparison returned that both elements are equal
			        return o1.compareSecond(o2);
			    } else {
			        return firstResult;
			    }
		}
		
	}
	
	
	public int calc() throws Exception
	{
		BufferedReader br = null;
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Pair> pairs = new PriorityQueue<Pair>(n, new PairComparator());
		
		for (int i = 0; i< n; i++)
		{
			String[] vals = br.readLine().split(" ");
			
			int t = Integer.parseInt(vals[0]);
			int f = Integer.parseInt(vals[1]);
			
			Pair p = new Pair(t - f, t + f);
			
			pairs.add(p);
			
			
		}
		
		
		
		List<Integer> bis = new ArrayList<Integer>();
				
		for (int i = 0; i < n; i++)
			{ Pair p  = pairs.poll();
			  bis.add(0, p.v2);
			}
			
		return LongestIncreasingSubsequenceLength(bis, n);
			
	}
	
	
	 static int CeilIndex(int[] A, int l, int r, int key)
	    {
	        while (r - l > 1)
	        {
	            int m = l + (r - l)/2;
	            if (A[m]>=key)
	                r = m;
	            else
	                l = m;
	        }
	 
	        return r;
	    }
	 
	    static int LongestIncreasingSubsequenceLength(List<Integer> A, int size)
	    {
	        // Add boundary case, when array size is one
	 
	        int[] tailTable   = new int[size];
	        int len; // always points empty slot
	 
	        tailTable[0] = A.get(0);
	        len = 1;
	        for (int i = 1; i < size; i++)
	        {
	        	int a_i = A.get(i);
	            if (a_i < tailTable[0])
	                // new smallest value
	                tailTable[0] =a_i;
	 
	            else if (a_i > tailTable[len-1])
	                // A[i] wants to extend largest subsequence
	                tailTable[len++] = a_i;
	 
	            else
	                // A[i] wants to be current end candidate of an existing
	                // subsequence. It will replace ceil value in tailTable
	                tailTable[CeilIndex(tailTable, -1, len-1, a_i)] = a_i;
	        }
	 
	        return len;
	    }
	

	public static void main(String[] args) throws Exception{
		
		
		Solution sol = new Solution();
		System.out.println(sol.calc());

	}

}
