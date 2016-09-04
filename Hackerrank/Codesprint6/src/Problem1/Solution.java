package Problem1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	int n;
	int k;
	
	int[] c;
	int bcharged;
	
	public int calc() throws Exception
	{
		BufferedReader br;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		
		String [] vals = br.readLine().split(" ");
		
		n = Integer.parseInt(vals[0]);
		k = Integer.parseInt(vals[1]);
		c = new int[n];
		
		vals = br.readLine().split(" ");
		
		int total = 0;
		int over = 0;
		
		for (int i = 0; i < n; i++)
		{
			c[i] = Integer.parseInt(vals[i]);
			total += c[i];
			
			if (i ==  k)
			{
				
				over += c[i];
			}
					
		}
		
		bcharged = Integer.parseInt(br.readLine());
		
		if (bcharged <= (total - over)/2)
			return 0; //"Bon Appetit";
		else
			return (bcharged - (total - over)/2);
				
		
		
		
	}

	public static void main(String[] args) throws Exception{
		
		Solution sol = new Solution();
		int ans = sol.calc();
		
		System.out.println((ans == 0) ? "Bon Appetit" : ans);

	}

}
