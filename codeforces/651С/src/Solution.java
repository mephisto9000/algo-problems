import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
	
	
	
	public void calc() throws Exception{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		//int arr[] = new int[n];
		Map<String, Integer> h = new HashMap();
		
		String[] vals ;
		
		for (int i = 0; i < n; i++)
		{
			vals = br.readLine().split(" ");
			
			long x = Long.parseLong(vals[0]);
			long y = Long.parseLong(vals[1]);
			
			String s = new String( x + "_"+ y);
			
			if (h.containsKey(s))
			{
				int val = h.get(s);
				val++;
				h.put(s,  val);
			}
			else
			{
				h.put(s, 1);
			}
		}
		
		
		Iterator<Integer> it = h.values().iterator();
		
		int ans = 0;
		while(it.hasNext())
		{
			int v = it.next();
			//ans+= Math.(v*(v-1))/2;
			int plus = 0;
			for (int i = v; i >0; i--)
				plus *= i; 
			
			ans+=plus;
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
