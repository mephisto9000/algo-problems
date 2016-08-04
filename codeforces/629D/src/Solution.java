import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	
	Cilinder[] cils;
	int n;
	
	double [][] memo;
	
	public class Cilinder{
		//V=π r2 h
		public int idx;
		public double vol;
		
		public Cilinder(int idx, int r, int h)
		{
			this.idx = idx;
			vol = Math.PI * r * r * h;
		}
	}
	
	public void calc() throws Exception
	{
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		memo = new double[n][n+1];
		
		
		for (int i = 0; i < n; i++)
		Arrays.fill(memo[i], -1);
		
		cils = new Cilinder[n]; 
		
		for (int i = 0; i < n; i++)
		{
			String vals[] = br.readLine().split(" ");
			
			Cilinder c = new Cilinder(i, Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));
			cils[n-i-1] = c;
		}
		
		System.out.println(rec(0,-1));
		
	}
	
	public double rec(int idx,  int baseIdx)
	{
		if (idx >= n)
			return 0;
		
		if (  memo[idx][baseIdx+1]!=-1)
			return memo[idx][baseIdx];

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
			//if (baseIdx >= 0) 
				memo[idx][baseIdx+1] = v1;
			return v1;
		}
		else
		{
			if (baseIdx >= 0)
				memo[idx][baseIdx+1] = v2;
			return v2;
		}
		
	
	
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();
		sol.calc();

	}

}
