import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {
	public String fname = null;

	int n;
	int a[];
	int b[];
	
	public int calc() throws Exception
	{
		BufferedReader br;
		
		
		if (fname == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader( new FileReader(fname));
		
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		b = new int[n];
		
		String [] vals = br.readLine().split(" ");
				
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(vals[i]);
		
		vals = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			b[i] = Integer.parseInt(vals[i]);
			
		
		Map<Integer, Integer> amap = new HashMap();
		Map<Integer, Integer> bmap = new HashMap();
		
		for (int i = 0; i < n; i++)
			{
			if (!amap.containsKey(a[i]))
				amap.put(a[i], 1);
			else
				amap.put(a[i],   amap.get(a[i])+1);
			}
		
		
		int v = 0;
		for (int i = 0; i < n; i++)
		{
			v++;
		if (!bmap.containsKey(b[i]))
			bmap.put(b[i], 1);
		else
			bmap.put(b[i], bmap.get(b[i])+1);
		}
		
		
			
		
		
		int ans = 0;
		
		Set keys = amap.keySet();
		
		Iterator kit = keys.iterator();
		boolean flag = false;
		
		while(kit.hasNext())
		{
			Integer key =   (Integer) kit.next();
			
			Integer aval = amap.get(key);
			Integer bval = bmap.get(key);
			
			if (bval != null)
			//	ans += aval < bval ? aval : bval;
				if (aval < bval)
						ans +=  aval;
					else
					{
						ans += bval;
						flag = true;
					}
		}
		
		if (ans < n  )
			ans ++;
		else
			ans --;
		
		
		return ans;
	}
	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		if (args.length > 0)
			sol.fname = args[0];
		
		
		System.out.println(sol.calc());
		
			

	}

}
