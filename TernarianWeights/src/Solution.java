import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	
	
	int wn = 0;
	List<Long> weights;
	
	List<Long> lefts;
	List<Long> rights;
	Map<String, Integer> memo;
	
	public void calc() throws Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
	
		weights = new LinkedList<Long>();
		long z = 1;
		weights.add(z);
		while(z <= 2000000000L)
		{			
			z*=3;
			weights.add(z);
			
		}
		
		memo = new HashMap<String, Integer>();
		
		lefts = new ArrayList<Long>();
		rights = new ArrayList<Long>();
		
		for (int i = 0; i < n; i++)
		{
			int v = Integer.parseInt(br.readLine());
			
			int l = 0;
			int r = weights.size() - 1;
			int middle = (r - l) / 2 + l;
			
			int idx = -1;
			
			lefts.clear();
			rights.clear();
			
			while(true)
			{
				
				
				int mv =  weights.get(middle).intValue();
				
				if (v == mv)
				{
					idx = middle;
					break;
				}
				
				if (r - l <= 1)
				{
					idx = r +1;
					break;
				}
				
				if (v < mv)
				{
					r = middle;
					 middle = (r - l) / 2 + l;
				}
				else
				{
					l = middle;
					 middle = (r - l) / 2 + l;
				}
				
				
			}
			
			 rec(v, 0, idx);
			 
			 StringBuffer sb = new StringBuffer("left pan:");
			 
			 for (int j = 0; j < lefts.size(); j++)
			 {
				 sb.append(" "+lefts.get(j));
			 }
			 
			 System.out.println(sb.toString());
			 
			 sb = new StringBuffer("right pan:");
			 
			 for (int j = 0; j < rights.size(); j++)
			 {
				 sb.append(" "+rights.get(j));
			 }
			 
			 System.out.println(sb.toString());
			 
			 System.out.println();
			 
			
			
		}
	}
	
	public int rec(long left, long right, int idx)
	{
		
		if (idx == -1)
		{
			if (left == right)
				return 0;
			else
				return -1;
		}
		
		long v = weights.get(idx);
		
		String key1 = String.valueOf(left+v)+"_"+String.valueOf(right);
		String key2 = String.valueOf(left)+"_"+String.valueOf(right+v);
		String key3 = String.valueOf(left)+"_"+String.valueOf(right);
		int v1 = rec(left + v, right, idx-1); //memo.containsKey(key1)?memo.get(key1):rec(left + v, right, idx-1);
		int v2 = rec(left, right + v, idx-1);  //memo.containsKey(key2)?memo.get(key2):rec(left, right + v, idx-1); 
				
		int v3 = rec(left, right, idx-1); // memo.containsKey(key3)?memo.get(key3) : rec(left, right, idx-1);
		
		if (v1==0)
		{
			//System.out.println("left "+v);
			lefts.add(0, v);
			//memo.put(key1, 0);
			return 0;
		}
			
		
		if (v2==0)
		{
			//System.out.println("right "+v);
			rights.add(0, v);
			//memo.put(key2, 0);
			return 0;
		}
		if (v3 == 0)
		{
			//memo.put(key3, 0);
			return 0;
		}
		
		//memo.put(key3, -1);
		return -1;
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {

		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
