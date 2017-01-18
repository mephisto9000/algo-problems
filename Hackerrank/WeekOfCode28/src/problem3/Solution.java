package problem3;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;




public class Solution {
	
	int[] mtx;
	int n;
	BigInteger eight = new BigInteger("8");
	
	List<TrieNode> nodes;
	Set<Integer> divisor3;
	
	TrieNode tn; // used for checking
	String src;
	
	BigInteger totalAns = BigInteger.ZERO;
	
	
	public class TrieNode
	{
		int digit;
		int idx;
		
		List<TrieNode> children;
		
		
		public boolean add(String v)						
		{ 
			//System.out.print(' ');
			//System.out.print(v);
			
			
			if (children == null)
				children = new LinkedList<TrieNode>();
			
			if (digit == -1)
			{
				
				//if (children.size() >0)
				boolean needToPropagate = true;
				for (TrieNode tn : children)
				{
					if (tn.add(v))
						needToPropagate = false;
				}
				
				if (needToPropagate)
				{
					//System.out.println("here!");
					TrieNode tn = new TrieNode();
					int t = getFirstIntFromStr(v);
					tn.digit = t;
					tn.children = new LinkedList<TrieNode>();
					children.add(tn);
					
					if (v.length() >1)
					{
						 //String v_str = Integer.toString(v);
						 //int new_v = Integer.parseInt(v_str.substring(1));
						 
						 return tn.add(v);
					}
					else 
						return true;
				}
			}
			else
			{
				int t = getFirstIntFromStr(v);
				
				if (t != digit)
					return false;
				else
				{
					if (v.length() >1)
					{
					 //String v_str = Integer.toString(v);
					 //int new_v = Integer.parseInt(v_str.substring(1));
					 String	new_v = v.substring(1);
						
					 //if (tn.check(new_x))
					 //	 return true;
					 
					 boolean needToPropagate = true;
					 
					 for (TrieNode tn : children)
					 {
						 if (tn.add(new_v))
							 needToPropagate = false;
					 }
					 
					 if (needToPropagate)
					 {
						 //tn.ad
						 TrieNode tn = new TrieNode();
							//int t = getFirstInt(v);
							tn.digit =  getFirstIntFromStr(new_v);
							tn.children = new LinkedList<TrieNode>();
							children.add(tn);
							
							return tn.add(new_v);
					 }
					 
					}
					return true;
					
					
				}
			}
			return false;
		}
		
		public void  printNode(String prefix)		
		{
			
			if (children.size() == 0)
				System.out.println(prefix + digit);
			
			for (int i = 0; i < children.size(); i++)
			{
				TrieNode tn = children.get(i);
				
				if (digit != -1)
					tn.printNode(prefix+ digit);
				else
					tn.printNode(prefix+" ");
				
			}
		}
		
		public boolean check(String v)
		{
			//if (v > 10)
			int t = getFirstIntFromStr(v);
			
			if (digit == t)
			{
				if (v.length() == 1)
					return true;
				else					
					for (TrieNode tn : children)
					{
						//if tn
						
						if (v.length() >1)
						{
						 //String x_str = Integer.toString(v);
						 //int new_x = Integer.parseInt(x_str.substring(1));
						 String new_x =  v.substring(1);
						 if (tn.check(new_x))
							 return true;
						}
						
					}
				return false;
			}
			else if (digit == -1)
			{
				for (TrieNode tn : children)
				{
					 if (tn.check(v))
						 return true;
					
				}
			return false;
			}
			else
				return false;
			
		}
	}
	
	int getFirstInt(int input) {
		  if (input > 0 ? input < 10 : input > -10) {
		    return input > 0 ? input : -input;
		  }
		  return getFirstInt(input / 10);
		}
	
	int getFirstIntFromStr(String v)
	{
		return  Character.getNumericValue(v.charAt(0));
	}
	
	
	public BigInteger func4()
	{
		BigInteger ans = BigInteger.ZERO;
		
		 divisor3 = new HashSet<Integer>();
		
		nodes = new LinkedList<TrieNode>();
		
		tn = new TrieNode();
		tn.digit = -1;
		tn.idx = - 1;
		tn.children = new LinkedList<TrieNode>();
		
		for (int i = 0; i <= 999; i++)
		{
			if (i % 8 == 0)
			{
				//System.out.println(i);
				divisor3.add(i);
				
				//tn.add(i);
				//int i = 5;
				//StringUtils.leftPad(String.valueOf(i), 3, "0"); // --> "005"
				tn.add(String.format("%03d", i));
			}
		}
		
		
		//tn.printNode("");
		
		for (int i = 0; i < n; i++)
		{
			//if (nodes.)
			int v = mtx[i];
			
			
			 recNum(i);
			
			/*
			if (zzz >= 0)
			{
				//System.out.println("zzz");
				ans += Math.pow(2, zzz);
			}
			*/
			

		}
		
		//System.out.println(totalAns.toString());
		ans = ans.add(totalAns);
		
		
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
			{
				int v = mtx[i] * 10 + mtx[j];
				
				if (divisor3.contains(v))
				{
					ans = ans.add(BigInteger.ONE);// ++;
				}
			}
			
		/*
		
		for (TrieNode t : nodes )
		{
			for (TrieNode t1 : t.children)
			{
				if (t1.children.size() == 0 && divisor3.contains(t.digit * 10 + t1.digit))
				{
					divisor3.remove(t.digit * 10 + t1.digit);
					//ans ++;
					ans = ans.add(BigInteger.ONE);
				}
			}
		} 
		*/
		
		
		for (int i = 0; i < n; i++)
		{
			int v = mtx[i];
			
			//if (divisor3.contains(v))
			//
			if (v % 8 == 0)
				//ans ++;
				ans = ans.add(BigInteger.ONE);
			//}
		}
		
		return ans;
		
		
		
		//System.out.println("set size == "+divisor3.size());
	}
	
	int recNum(  int idx)
	{
		
		boolean done = false;
		
		int ans = -1;
		for (int i = 0; i < nodes.size(); i++)
		{
			//if (nodes.contains(o)
			TrieNode t = nodes.get(i);
			
			//if (t.digit == mtx[idx])
			{
				for (int j = 0; j < t.children.size(); j++)
				{
					TrieNode t2 = t.children.get(j);
					
					//if (t2.digit == mtx[idx])
					
					int v = t.digit * 100 + t2.digit * 10 + mtx[idx];
					
					String vstr = String.format("%03d", v);
					
					//System.out.println("vstr == "+vstr);
					
					if (tn.check(vstr))
					{
						/*
						t.children.remove(j);
						if (t.children.size() == 0)
							nodes.remove(i);
						*/
						
						//System.out.println("blah"); 
						//System.out.println("here = "+vstr);
						
						//return t.idx;
						ans = t.idx;
						BigDecimal k = BigDecimal.valueOf(Math.pow(2, t.idx));
						//System.out.println(k.toBigInteger());
						totalAns = totalAns.add(k.toBigInteger());// += ;
						
						//System.out.println(totalAns.toString());
					}
					
				}
				
				int v = t.digit * 10 +   mtx[idx]; 
				String vstr = String.format("%02d", v);
				if (tn.check(vstr))
				{
					TrieNode tnt = new TrieNode();
					tnt.children = new LinkedList<TrieNode>();
					tnt.idx = idx;
					tnt.digit = mtx[idx];
					t.children.add(tnt);
					done = true;
				}
				
			}
			
		}
		
		if (tn.check(String.valueOf(mtx[idx])) )
		{
			
			boolean needToAdd = true;
			for (int i = 0; i < nodes.size(); i++)
			{
				TrieNode t = nodes.get(i);
				if (t.children.size() == 0 && t.digit == mtx[idx])
					needToAdd = false;
			}
			
			if (!needToAdd)
				return -1;
			
			TrieNode tnt = new TrieNode();
			tnt.digit = mtx[idx];
			tnt.idx = idx;
			tnt.children = new LinkedList<TrieNode>();
			nodes.add(tnt);
			//System.out.println("im' here");
		}
			
			
		
		return -1;
	}

	
	public long func3()
	{
		long ans = 0;
		
		Set<Integer> divisor3 = new HashSet<Integer>();
		
		for (int i = 0; i <= 999; i++)
		{
			if (i % 8 == 0)
			{
				//System.out.println(i);
				divisor3.add(i);
			}
		}
		
		//System.out.println("set size == "+divisor3.size());
		
		divisor3.add(0);
		
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				for (int k = j+1; k < n; k++)
				{
					int v = mtx[i] * 100 + mtx[j] * 10 + mtx[k];
					
					
					if (divisor3.contains(v))
					{
						
						//System.out.println("here "+v);
						ans += Math.pow(2, i);
					}
				}
		
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
			{
				int v = mtx[i] * 10 + mtx[j];
				
				if (divisor3.contains(v))
				{
					ans ++;
				}
			}
		
		
		for (int i = 0; i < n; i++)
		{
			int v = mtx[i];
			
			if (divisor3.contains(v))
			{
				ans ++;  
			}
		}
		
		return ans;
	}

	public long func2(String base, int idx)
	{
		long ans = 0;

		//if (Long.parseLong(base + mtx[idx]) % 8 == 0 )
		if (new BigInteger(base + mtx[idx]).mod(eight) == BigInteger.ZERO)
		{
			ans++;
		}

		if (idx < n-1)
		{
			ans+= func2(base, idx+1);
			ans+=  func2(base +  mtx[idx], idx+1);
		}

		return ans;
	}
	
	 
	public long calc() throws Exception
	{
		Scanner sc = null; 
		
		if (src == null)
			sc = new Scanner(System.in);
		else
		{
			 File file = new File(src);
	        
			sc = new Scanner(file);
		}
		
		n = sc.nextInt();
		
		String val = sc.next();
				
		mtx = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			mtx[i] = Character.getNumericValue(val.charAt(i));
		}

		//Arrays.sort(mtx);

		///long ans = calcPerm();
		//long ans = func2("", 0);
		BigInteger ans = func4();
		BigInteger md = BigInteger.valueOf( 1000000000 + 7);

		return ans.mod(md).longValue(); // %  (1000000000 + 7);
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		System.out.println(sol.calc());

	}

}
