import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++)
		{
			String[] vals = br.readLine().split(" ");
			
			String s1 = vals[0];
			String s2 = vals[1];
			
			Map hm = new HashMap();
			
			for (int j = 0; j < s1.length(); j++)
			{
				int shift = getShift( s1.charAt(j),s2.charAt(j));
				
				if (hm.containsKey(shift))
				{
					int v = (Integer) hm.get(shift);
					v++;
					hm.put(shift, v);
					
				}
				else
				{
					hm.put(shift, 1);
				}
			}
			
			int res = s1.length();
			if (hm.size() > 1 )
			{
				
				Collection c =  hm.values();
				res = Integer.MIN_VALUE;
				
				Iterator it = c.iterator();
				//for (int j = 0; j < c.size(); j++)
				while(it.hasNext())
				{
					
					int v = (Integer) it.next();//c.get(j);
					if (res < v)
						res = v;
				}
			}
			
			System.out.println(s1.length() - res);
			
		}
	}
	
	int getShift(char c1, char c2)
	{
		//int val = 0;
		
		
		//int offset  = 0;
		int z = 0;
		while(c1 != c2)
		{
			if (c1 >= 'z')
				c1 = 'a';
			else
				c1++;
			z++;
		}
		return z;
	}
	
	
	public static void main(String[] args) throws Exception{

		
		Solution sol = new Solution();
		sol.calc();

	}

}
