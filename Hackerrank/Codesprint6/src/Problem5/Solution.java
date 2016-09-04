package Problem5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	String src = null;
	
	BigInteger n; //num of sticks to buy
	long k; //num of boxes store has;
	int b ; //num of boxes to buy
	
	int tcase;
	
	BigInteger[] sumToBuy;
	
	//final String nope = "-1";
	
	 //int arr[] = {1, 3, 5, 7, 9, 11};
	List<BigInteger> initArr;
	
	String memo[][][];
	
	private static final double LOG2 = Math.log(2.0);
	
	public static double logBigInteger(BigInteger val) {
	    int blex = val.bitLength() - 1022; // any value in 60..1023 is ok
	    if (blex > 0)
	        val = val.shiftRight(blex);
	    double res = Math.log(val.doubleValue());
	    return blex > 0 ? res + blex * LOG2 : res;
	}
	
	
	class SegTree
	{
		
		List<BigInteger> st;
		
		
		SegTree(List<BigInteger> arr, long k)
		{
			//Math.log(n.)
			//int x = (int) (logBigInteger(k) / Math.log(2));
			int x = (int) Math.ceil((Math.log(k) / Math.log(2)));
			
			int max_size = 2 * (int) Math.pow(2,  x) - 1;
			
			st = new ArrayList<BigInteger>(); // is that ok ?
			for (int i = 0; i < max_size; i++)
				st.add(BigInteger.ZERO);
			
			constructSTUtil(arr, 0, k-1,0);
			
			
		}
		
		  long getMid(long s, long e) {
		        return s + (e - s) / 2;
		    }
		
		BigInteger constructSTUtil(List<BigInteger> arr, int ss, long l, int si)
	    {
	        // If there is one element in array, store it in current node of
	        // segment tree and return
			
			//System.out.println("i'm here");
	        if (ss == l) {
	        	
	        	//System.out.println("si == "+si+" ss == "+ss);
	            st.set(si, arr.get(ss));
	            
	            if (st.get(si).compareTo(n) == 0)
	            	System.out.println("found!!");
	            return arr.get(ss);
	        }
	 
	        // If there are more than one elements, then recur for left and
	        // right subtrees and store the sum of values in this node
	        int mid = (int) getMid(ss, l);
	        st.set(si, constructSTUtil(arr, ss, mid, si * 2 + 1).add(
	                 constructSTUtil(arr, mid + 1, l, si * 2 + 2)));
	        
	        if (st.get(si).compareTo(n)==0)
	        	System.out.println("found!!");
	        return st.get(si);
	    }
		
		
		 BigInteger getSumUtil(int ss, int se, int qs, int qe, int si)
		    {
		        // If segment of this node is a part of given range, then return
		        // the sum of the segment
		        if (qs <= ss && qe >= se)
		            return st.get(si);
		 
		        // If segment of this node is outside the given range
		        if (se < qs || ss > qe)
		            return BigInteger.ZERO;
		 
		        // If a part of this segment overlaps with the given range
		        int mid = (int) getMid(ss, se);
		        return getSumUtil(ss, mid, qs, qe, 2 * si + 1).add(
		                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2));
		    }
		 
		 
		 BigInteger getSum(int n, int qs, int qe)
		    {
		        // Check for erroneous input values
		        if (qs < 0 || qe > n - 1 || qs > qe) {
		            System.out.println("Invalid Input");
		            return BigInteger.ZERO.subtract(BigInteger.ONE);
		        }
		        return getSumUtil(0, n - 1, qs, qe, 0);
		    }
		 
		 
		 void updateValue(int arr[], int n, int i, int new_val)
		    {
		        // Check for erroneous input index
		        if (i < 0 || i > n - 1) {
		            System.out.println("Invalid Input");
		            return;
		        }
		 
		        // Get the difference between new value and old value
		        int diff = new_val - arr[i];
		 
		        // Update the value in array
		        arr[i] = new_val;
		 
		        // Update the values of nodes in segment tree
		        updateValueUtil(0, n - 1, i, diff, 0);
		    }
		 
		 
		 void updateValueUtil(int ss, int se, int i, int diff, int si)
		    {
		        // Base Case: If the input index lies outside the range of 
		        // this segment
		        if (i < ss || i > se)
		            return;
		 
		        // If the input index is in range of this node, then update the
		        // value of the node and its children
		        st.set(si, st.get(si).add(BigInteger.valueOf(diff)));
		        if (se != ss) {
		            int mid = (int) getMid(ss, se);
		            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
		            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		        }
		    }
		
		
	}
	
	
	
	
	public String calc() throws Exception{
		BufferedReader br ;
		
		
		
		if (src ==null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		 int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		
		sumToBuy = new BigInteger[t];
		for (int i = 0 ; i < t; i++)
		{
			
			String[] vals = br.readLine().split(" ");
			

			 n = new BigInteger(vals[0]);

			k = Long.parseLong(vals[1]);
			
			 b = Integer.parseInt(vals[2]);
			 
			 //memo = new String[n][n][n];
			
			//long nsum = 0;
			//long bsum = 0;
			
			//for (BigInteger z = n; z.compareTo(BigInteger.ZERO)==1; z = z.subtract(BigInteger.ONE))
			 
			BigInteger tmp = BigInteger.ONE; 
			initArr = new LinkedList<BigInteger>();
			
			tcase = i;
			
			//sumToBuy = 
			for (long j = 0; j < k; j++)
			{
				initArr.add(tmp);
				tmp = tmp.add(BigInteger.ONE);
			}
			
			SegTree st = new SegTree(initArr, k);
			 
			 
			//if (sb.length()>0)
			//	sb.append("\n");
			//sb.append(rec(1, 0, 0).toString().trim());
			
		}
		
		
		return null; //sb.toString();
	}
	
	/*
	public StringBuffer rec(long idx, long sum, int count)
	{
		
		//System.out.println("idx="+idx+" sum="+sum+" count="+count +" sticksNeeded="+n+" boxesNeeded="+b);
		
		
		if (sum == n && count == b)
		{
			//System.out.println("nice!!!");
			return new StringBuffer(); //""; //String.valueOf(idx);
		}
		
		
		if (idx > k)
			return new StringBuffer(nope);
		
		if (idx + sum >n)
			return new StringBuffer(nope);
		
		StringBuffer s1 = rec(idx+1, sum+idx, count+1);
		
		
		if (!s1.toString().equals(nope))
			//return idx + " " + s1;
		{
			s1.append(' ');
			s1.append(idx);
			return s1;
		}
		else
		{
			StringBuffer s2 = rec(idx+1, sum, count);
			return s2;
		}
		
						
	} */
			

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
