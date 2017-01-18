package Problem1;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution {
	
	String src;
	
	class Hotel implements Comparable
	{
		int id;
		int count;
		@Override
		public int compareTo(Object o) {
			Hotel h2 = (Hotel) o;
			
			if (this.count > h2.count)
				return -1;
			
			if (this.count < h2.count)
				return 1;
			
			return 0;
		}
	}
	
	Map<Integer, Hotel> hotels;
	
	public String calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		  String[] vals = br.readLine().split(" ");
		  
		  StringBuffer sb = new StringBuffer();
		  int before = 0;
		  
		  for (int i = 0; i < vals.length; i++)
		  {
			  int v = Integer.parseInt(vals[i]);
			  
			  if (i == 0)				  
				  sb.append(v);
			  else
			  {
				  v -=  Integer.parseInt(vals[i-1]); //before;
			  
			  if (v < -128 || v > 128)
				  {
				  sb.append(-128);
				  sb.append(" ");
				  
				  }
			  sb.append(v);
			  }
			  sb.append(" ");
			  
			  before = v;// Integer.parseInt(vals[i]);
			  
		  }
		  
		  return sb.toString().trim();
			
	}
	
	
    public static void main(String args[] ) throws Exception {

    	Solution sol = new Solution();
    	
    	System.out.println(sol.calc());


    }
}