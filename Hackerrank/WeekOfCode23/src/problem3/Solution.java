package problem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	double k = 0;
	double n = 0;
	
	long x,y = 0;
	long a,b = 0;
	
	String src = null;
	
	public void calc() throws Exception{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String vals[] = br.readLine().split(" ");	
		x = Long.parseLong(vals[0]);
		y = Long.parseLong(vals[1]);
		
		vals = br.readLine().split(" ");
		
		a = Integer.parseInt(vals[0]);
		b = Integer.parseInt(vals[1]);
		
		double d = - (b*x - a*y) / Math.sqrt(a*a + b*b);
		
		double ablen = Math.sqrt(a*a + b*b);
		
		
		k = (Math.sqrt((x*x + y*y) - d*d )/ ablen);
		
		n = d / ablen;
		
		
				
		
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		sol.calc();
		System.out.println(sol.k);
		System.out.println(sol.n);

	}

}
