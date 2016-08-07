import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		long k = Long.parseLong(vals[1]);
		
		vals = br.readLine().split(" ");
		
		Set<Long> dict = new HashSet<Long>();
		
		int ans = 0;
		for (int i = 0; i < n; i++)
		{
			Long v = Long.parseLong(vals[i]);
			
			if (dict.contains(v + k))
				ans ++;
			if (dict.contains(v - k))
				ans ++;
			dict.add(v);
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
