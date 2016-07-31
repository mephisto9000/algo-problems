
	import java.io.*;
import java.math.BigInteger;
import java.util.*;

	public class Solution {
		
	   public class MST{
		   public int parent[];
		   public int members[];
		   public int triggered[];
		   
		   public int n;
		   
		   public MST(int n)
		   {
			   this.n = n;
			   parent = new int[n+1];
			   members = new int[n+1];
			   triggered = new int[n + 1];
			   for (int i = 0; i <= n; i++)
			   {
				   parent[i] = i;
				   members[i] = 1;
				   triggered[i] = 0;
			   }
		   }
		   
		   //public int getMembersNum
		   
		   public int find(int x)
		   {
			   if (parent[x] == x)
				   return x;			   
			   else
				   return find(parent[x]);				   
		   }
		   
		   public int getNumMembers(int x)
		   {
			   int px = find(x);
			   return members[px];
		   }
		   
		   public void union(int x, int y)
		   {
			   triggered[x] = 1;
			   triggered[y] = 1;
			   
			   int px = find(x);
			   int py = find(y);
			   
			   
			   Random randomGenerator = new Random();
			   int r = 0;			   
			      r = randomGenerator.nextInt(2);
			   

			      if (r == 0)
			      {
			   
			    	  int membersOfSubtree = members[px];
			   			   			   
			    	  if (px != py)
			    	  {
			    		  parent[px] = py;
			    		  members[py] += membersOfSubtree;
			    	  }
			      }
			      else
			      {
			    	   int membersOfSubtree = members[py];
			   			   
					   if (px != py)
					   {
						   parent[py] = px;
						   members[px] += membersOfSubtree;
					   }
			      }
		   }
		   
	   }
	   
	   public MST mst;
	   public Solution(int n)
	   {
		   mst = new MST(n);
	   }
	   
	   
	   
	   
		
	   public static void main(String[] args) throws Exception{
	        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		    //BufferedReader bfr = new BufferedReader(new FileReader("input2.txt"));
		   
	        String[] temp = bfr.readLine().split(" ");
	        int N = Integer.parseInt(temp[0]);
	        int I = Integer.parseInt(temp[1]);
	        
	        Solution sol = new Solution(N);
	        
	        //MST mst = new MST(N);
	        
	        
	      

	        for(int i = 0; i < I; i++){
	            temp = bfr.readLine().split(" ");
	            int a = Integer.parseInt(temp[0]);
	            int b = Integer.parseInt(temp[1]);
	            sol.mst.union(a, b);
	          // Store a and b in an appropriate data structure of your choice
	        }
	        List<Integer> countries = new LinkedList<Integer>();
	        for (int i = 0; i < N; i++)
	        {
	        	if (sol.mst.parent[i] == i && sol.mst.triggered[i] == 1)
	        	{
	        		countries.add(sol.mst.members[i]);
	        	}
	        }
	        
	        long combinations = 0;
	        
	        
	        /*
	        for (int i = 0; i < countries.size(); i++)
	        {
	        	if (combinations == 0)
	        		combinations = countries.get(i);
	        	else
	        		combinations *= countries.get(i);
	        }
	        */
	        
	        int []v = new int[countries.size()];
	        int c = countries.size();
	        for (int i = 0; i < c; i++)
	        {
	        	v[i] = countries.get(i);
	        	//System.out.println("c == "+v[i]);
	        }
	        
	        //Arrays.sort(v);
	        
	        /*
	        for (int i = 0 ; i < c-1; i++)
	        	for (int j = i+1; j < c; j++ )
	        		combinations += (v[i] * v[j]);
	        		*/
	        //combinations = ( N * (N-1) ) / 2;
	        BigInteger bi = BigInteger.valueOf( N) ;// * (N-1) ) / 2);
	        bi = bi.multiply(BigInteger.valueOf(N-1));
	        bi = bi.divide(BigInteger.valueOf(2));
	        
	        for (int i = 0; i < c; i++)
	        {
	        	//combinations -= (v[i] * (v[i]-1) / 2);
	        	
	        	long tval = (v[i] * (v[i]-1) / 2);
	        	
	        	bi = bi.subtract(BigInteger.valueOf(tval) );
	        }

	    	//bi = bi.subtract(BigInteger.valueOf(2) );
	   
	        

	        // Compute the final answer - the number of combinations
	       
	        System.out.println(bi.toString());

	    }
	}

	 
	




