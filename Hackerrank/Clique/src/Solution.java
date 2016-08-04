import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	 
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int t = Integer.parseInt(br.readLine());
		String[] vals;
		
		
		
		for (int i = 0; i < t; i++)
		{
		  
			vals = br.readLine().split(" ");
			
			int n = Integer.parseInt(vals[0]);
			int m = Integer.parseInt(vals[1]);
			
			System.out.println(calcClique(n,m));
		}
	}
	
	
	public int calcClique(int n, int m)
	{
		float rf = n-1;
		int r = n-1;
		
		int rmin = 0;
		int rmax = r;
		
		while (true)
		{
			
			if (rmax-rmin <=1)
				return r+1;
			 
		/*	 
			
			
		//double upperBound = (rf - 1)*n*n/(2.0f*rf);
		
		int nmodr  = n % r;
		double ndivrceil =  Math.pow(Math.ceil(n/rf),2);
		double ndivrfloor = Math.pow(Math.floor(n/rf), 2);
		//double ndirv
		double left = (0.5f)*(n*n - (nmodr)*ndivrceil - (r - (nmodr))*ndivrfloor);
		
		if (left < m) 
			return r+1;
		
		r--;
		rf -=1;
		*/
			
			if (testClique(n,m, rf, r))
			{
				rmin = r;
				
				r = r + (rmax - r)/2;
				 rf = r;
			}
			else
			{
				rmax = r;
				r = rmin + (r - rmin)/2;
				rf = r;
			}
				
		}
		
		//return -1;
		
		
	}
	
	boolean testClique(int n, int m, float rf, int r)
	{
		int nmodr  = n % r;
		double ndivrceil =  Math.pow(Math.ceil(n/rf),2);
		double ndivrfloor = Math.pow(Math.floor(n/rf), 2);
		//double ndirv
		double left = (0.5f)*(n*n - (nmodr)*ndivrceil - (r - (nmodr))*ndivrfloor);
		
		if (left < m) 
			return true;
		else
			return false;
	}
	
	 

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		sol.calc();

	}

}