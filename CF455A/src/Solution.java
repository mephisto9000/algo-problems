import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	HashMap<Integer, List> vmap;
	int[] intv;
	int n = 0; 
	
	Map<String, Integer> memo;
	//Map<Integer, List> stack;

	public void calc() throws Exception
	{
		
		//vmap.
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input7.txt"));
		
		n = Integer.parseInt(br.readLine());
		
		String [] vals = br.readLine().split(" ");
		
		vmap = new HashMap<Integer, List>();
		
		memo = new HashMap<String, Integer>();
		
		intv = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			intv[i] = Integer.parseInt(vals[i]);
			
			//memo[i] = new int[1000000];
			//Arrays.fill(memo[i], -1);
			
			if (vmap.containsKey(intv[i]))
			{
				//List val = vmap.get(intv[i]);
				//val.add(intv[i]);
				//vmap.put(intv[i], val);
			}
			else
			{
				List l = new LinkedList<Integer>();
				//l.add(i);
				vmap.put(intv[i], l);
			}// */
		}
		
		Arrays.sort(intv);
		
		 //stack = new HashMap<Integer>();
		int res = rec(0);
		
		System.out.println(res);

	}

	public int rec(int idx )
	{

		if (idx >= n)
			return 0;

		Integer memv = memo.get(stackToStr(vmap)+"+"+idx);

		if (memv!=null)
			return memv;

		int v = intv[idx];

		int res = 0;


		int v0 = 0;
		int v1 = 0;
		int v2 = 0;

		if (vmap.containsKey(v) && (vmap.get(v).size() > 0))
		{
			//pathetic
			 v0 =  rec(idx+1);
		}
		else
		{			
			
			
			v1 =  rec(idx+1);
			
			
			
			int vp1 = v+1;
			int vm1 = v-1;
			
			//stack.add(vp1);
			//stack.add(vm1);
			List l1 = vmap.get(vp1);
			List l2 = vmap.get(vm1);
			
			if (l1 !=null )				
				l1.add(1);
			else
			{
				l1 = new LinkedList<Integer>();
				l1.add(1);
				vmap.put(vp1, l1);
			}
			
			if (l2 !=null )				
				l2.add(1);
			else
			{
				l2 = new LinkedList<Integer>();			
				l2.add(1);
				vmap.put(vm1, l2);
			}
			
			
			v2 = v + rec(idx+1);
			//stack.remove(vp1);
			//stack.remove(vm1);
			
			l1.remove(0);
			l2.remove(0);
		}

		if (v0 > res)
			res = v0;

		if (v1 > res)
			res = v1;
		
		if (v2 > res)
			res = v2;

		System.out.println(stackToStr(vmap)+"+"+idx);
		
	
        memo.put(stackToStr(vmap)+"+"+idx, res);
		
		//if (memv!=null)
		//	return memv;
		return res;
	}
	
	public String stackToStr(HashMap<Integer, List> vmap)
	{
		
		Set<Integer> keys = vmap.keySet();
		
		//Collections.sort(keys);
		
		
		
		Iterator keyit = keys.iterator();
		
		//
		List b = new LinkedList();
		
		while(keyit.hasNext())
		{
			Integer key = (Integer) keyit.next();
			
			List l = vmap.get(key);
			
			if (l!=null && l.size() > 0)
			{
				b.add(key);
			}
		}

		Collections.sort(b);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.size(); i++)
		{
			sb.append("_"+b.get(i));
		}

		return sb.toString();
	}


	public static void main(String[] args) throws Exception{
		Solution sol = new Solution();

		sol.calc();
	}

}
