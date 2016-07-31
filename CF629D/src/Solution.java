import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	
	Cilinder[] cils;
	List<Cilinder> cilsList;
	int n;
	
	double[] dp;
	int max_idx;
	double q[];
	
	//double [][] memo;
	
	public class Cilinder implements Comparable{
		//V=π r2 h
		public int idx;
		public double vol;
		
		public Cilinder(int idx, int r, int h)
		{
			this.idx = idx;
			vol =    r * r * h;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			
			Cilinder c1 = this;
			Cilinder c2 = (Cilinder) o;
			
			if (c1.vol < c2.vol) return -1;
			
			if (c1.vol > c2.vol) return 1;
			
			
			return 0;
		}
	}
	
	
	public class Segment{
		public int leftIdx;
		public int rightIdx;
		public double sum;
		public Segment left = null;
		public Segment right = null;
	}
	
	public double query(int ql, int qr)
	{
		return query(ql, qr, 1, 0, n);
	}
	
	public double query(int ql, int qr, int id, int b , int e) 
	{
		if (ql >= e || qr <= b) return 0;
		if (ql <= b && e <= qr) return q[id];
		
		int mid = (b + e) >> 1;   // (b + e) / 2
		int l = id << 1;		// l = id * 2
		int r = l | 1;			// r = l + 1
		
		return max (query (ql, qr, l, b, mid), query(ql, qr, r, mid, e));
	}
	
	
	public void update(int idx, double x)
	{
		update(idx, x, 1, 0, n);
	}
	
	public void update(int idx, double x, int id, int min_idx, int max_idx)
	{
		if (idx < min_idx || idx >= max_idx) return;
		if (idx == min_idx && max_idx - min_idx == 1) {
			q[id] = dp[min_idx] = x;
			return;
		}
		
		int mid = min_idx + (max_idx - min_idx)/2;   //min_idx + max_idx >> 1;
		int l = id * 2; //  id << 1;
		int r = l | 1;
		
		if (idx < mid) {
			update (idx, x, l, min_idx, mid);
		}
		else
		{
			update(idx, x, r, mid, max_idx);
		}
		
		q[id] = max(q[l], q[r]);
		
	}
	
	public double max(double a, double b)
	{
		if (a > b)
			return a;
		else
			return b;
	}
	
	public void calc() throws Exception
	{
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		//memo = new double[n][n+1];
		
		
		//for (int i = 0; i < n; i++)
		//	Arrays.fill(memo[i], -1);
		
		
		int h = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		
		max_idx = 2*(int) Math.pow(2, h) - 1;
		
		
		//System.out.println(max_idx);
		
		 int n_ = 1000000; //1e5 + 1000;
		dp = new double[n_];
		q = new double[4 * n_];
		
		
		
		cils = new Cilinder[n]; 
		cilsList = new ArrayList<Cilinder>();
		
		for (int i = 0; i < n; i++)
		{
			String vals[] = br.readLine().split(" ");
			
			Cilinder c = new Cilinder(i, Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));
			cils[n-i-1] = c;
			
			cilsList.add(c);
			
		}
		
		Collections.sort(cilsList);
		
		
		for (int i = 0; i < n; i++)
		{
			Cilinder c = cilsList.get(i);
			
			double curr = c.vol;
			dp[c.idx] = query(0, c.idx) + curr;
			update(c.idx, dp[c.idx]);
		}
		
		
		
		
		double d = query(0,n);
		
		
		DecimalFormat dform = new DecimalFormat("0.###E0");
		
		System.out.println(String.format("%.9f", Math.PI * d).replace(',', '.'));
		//Segment s = buildSegment(0, n-1);
		
	}
	
	 
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	
	public double rec(int idx,  int baseIdx)
	{
		if (idx >= n)
			return 0;
		
		//if (  memo[idx][baseIdx+1]!=-1)
		//	return memo[idx][baseIdx];
		
		

		double v = cils[idx].vol;
		
		double v1 = 0;
		double v2 = 0;
		
		double baseVol = 0;
		
		if (baseIdx >=  0) 
			baseVol = cils[baseIdx].vol;
		
		
		if (v  < baseVol || baseVol == 0)
		{
			v1 = v +rec(idx+1,  idx);
		}
		
		v2 = rec(idx+1, baseIdx);
		
		
		if (v1 > v2)
		{ 
				//memo[idx][baseIdx+1] = v1;
			//memo[idx][baseIdx+1] = v1;
			return v1;
		}
		else
		{
			//if (baseIdx >= 0)
				//memo[idx][baseIdx+1] = v2;
				//memo[idx][baseIdx+1] = v2;
			return v2;
		}
		
	
	
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();
		sol.calc();

	}

}